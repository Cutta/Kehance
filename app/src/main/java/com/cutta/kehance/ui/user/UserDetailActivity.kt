package com.cutta.kehance.ui.user

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.cutta.kehance.R
import com.cutta.kehance.data.remote.model.ProjectItem
import com.cutta.kehance.data.remote.model.UserInfo
import com.cutta.kehance.data.remote.model.UsersItem
import com.cutta.kehance.ui.base.BaseActivity
import com.cutta.kehance.ui.detail.DetailActivity
import com.cutta.kehance.ui.main.ProjectListAdapter
import com.cutta.kehance.util.TransformationType
import com.cutta.kehance.util.extension.*
import kotlinx.android.synthetic.main.activity_user_detail.*
import kotlinx.android.synthetic.main.item_project.view.*
import kotlinx.android.synthetic.main.layout_user_detail_header.*

/**
 * Created by CuneytCarikci on 22/01/2018.
 */

class UserDetailActivity : BaseActivity<UserDetailViewModel>(), ProjectListAdapter.ProjectClickListener {

    companion object {
        private const val INTENT_EXTRA_USER_ID = "UserDetailActivity:Id"
        private const val INTENT_EXTRA_USER_NAME = "UserDetailActivity:Name"

        @JvmStatic
        fun getIntent(context: Context, userId: Int, userName: String): Intent {
            val intent = Intent(context, UserDetailActivity::class.java)
            intent.putExtra(INTENT_EXTRA_USER_ID, userId)
            intent.putExtra(INTENT_EXTRA_USER_NAME, userName)
            return intent
        }
    }

    private lateinit var userInfo: UserInfo
    private lateinit var projectsAdapter: ProjectListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setToolBar()
        initViews()
        observeViewModel()
    }

    private fun setToolBar() {
        setSupportActionBar(toolbar)
        toolbarTitle.text = intent.getStringExtra(INTENT_EXTRA_USER_NAME)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initViews() {

        appBar.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            val percentage = Math.abs(verticalOffset).toFloat() / appBarLayout.totalScrollRange
            toolbarTitle.alpha = percentage
            decreaseCollapsingAlphaSmoothly(percentage)
        }

        projectsAdapter = ProjectListAdapter(layoutResId = R.layout.item_project, listener = this) {
            with(it) {
                projectImage.load(covers.jsonMember404)
                projectOwnerName.text = owners.getOrNull(0)?.displayName ?: ""
                projectName.text = name
                projectField.text = fields.getOrElse(0, { _ -> "" })
                projectLikeCount.text = stats.appreciations.toString()
                projectViewsCount.text = stats.views.toString()
            }
        }

        projectsRecyclerView.apply {
            layoutManager = GridLayoutManager(this@UserDetailActivity, if (isPortrait()) 2 else 3)
            setHasFixedSize(true)
            adapter = projectsAdapter
            scheduleLayoutAnimation()
        }


        swipeRefreshLayout.setOnRefreshListener {
            observeViewModel()
        }
    }

    private fun decreaseCollapsingAlphaSmoothly(percentage: Float) {

        userImage.alpha = 1.0F - (percentage + 0.25F)
        userFields.alpha = 1.0F - (percentage + 0.2F)

    }

    private fun observeViewModel() {
        swipeRefreshLayout.isRefreshing = true
        viewModel.setUserId(intent.getIntExtra(INTENT_EXTRA_USER_ID, -1))
        viewModel.userDetails.reObserve(this, Observer {
            setViews(it?.user!!)
            swipeRefreshLayout.isRefreshing = false
        })

        viewModel.projects.reObserve(this, Observer {
            it?.projects.let {
                projectsAdapter.update(it)
                swipeRefreshLayout.isRefreshing = false
            }

        })

    }

    private fun setViews(user: UsersItem) {

        userImage.loadWithCallback(user.images.jsonMember276, TransformationType.CIRCLE, {
            onSuccess {
                userImage.post({
                    setToolbarColorFromImage()
                })
            }
            onError { Log.d("LISTENER", "ERROR") }
        })
        userFields.text = user.fields?.joinToString()
        userLikeCount.text = user.stats.appreciations.toString()
        userViewsCount.text = user.stats.views.toString()
    }


    private fun setToolbarColorFromImage() {
        userImage.generatePalette gen@ {
            val swatch = it.mutedSwatch ?: it.vibrantSwatch ?: it.lightMutedSwatch
            ?: it.lightVibrantSwatch ?: return@gen
            val backgroundColor = swatch.rgb

            collapsingToolbarLayout.circularReveal(backgroundColor)
            collapsingToolbarLayout.setContentScrimColor(backgroundColor)
        }
    }

    override fun getLayoutId() = R.layout.activity_user_detail

    override fun getViewModel() = UserDetailViewModel::class.java

    override fun onProjectClick(item: ProjectItem) {
        startActivity(DetailActivity.getIntent(this, item.id, item.name))
    }
}