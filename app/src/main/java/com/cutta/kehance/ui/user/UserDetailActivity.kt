package com.cutta.kehance.ui.user

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.cutta.kehance.R
import com.cutta.kehance.data.remote.model.UserInfo
import com.cutta.kehance.data.remote.model.UsersItem
import com.cutta.kehance.ui.base.BaseActivity
import com.cutta.kehance.util.TransformationType
import com.cutta.kehance.util.extension.*
import kotlinx.android.synthetic.main.activity_user_detail.*
import kotlinx.android.synthetic.main.layout_user_detail_header.*
import kotlin.math.absoluteValue

/**
 * Created by CuneytCarikci on 22/01/2018.
 */

class UserDetailActivity : BaseActivity<UserDetailViewModel>() {

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setToolBar()
        initViews()
        // setRecyclerView()
        observeViewModel()
    }

    private fun setToolBar() {
        setSupportActionBar(toolbar)
        //supportActionBar?.title = intent.getStringExtra(INTENT_EXTRA_USER_NAME)
        toolbarTitle.text = intent.getStringExtra(INTENT_EXTRA_USER_NAME)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initViews() {
        appBar.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            val percentage = Math.abs(verticalOffset).toFloat() / appBarLayout.totalScrollRange
            toolbarTitle.alpha = percentage
            decreaseCollapsingAlphaSmoothly(percentage)
        }
    }

    private fun decreaseCollapsingAlphaSmoothly(percentage: Float) {

        userImage.alpha = 1.0F - (percentage + 0.3F)
        userFields.alpha = 1.0F - (percentage + 0.2F)

    }

    private fun observeViewModel() {
        viewModel.setUserId(intent.getIntExtra(INTENT_EXTRA_USER_ID, -1))
        viewModel.userDetails.observe(this, Observer {
            setViews(it?.user!!)
        })
    }

    private fun setViews(user: UsersItem) {

        userImage.loadWithCallback(user.images.jsonMember276, TransformationType.CIRCLE, {
            onSuccess {
                userImage.post({ setToolbarColorFromImage() })
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
            // val titleTextColor = swatch.titleTextColor

            // toolbarTitle.setTextColor(titleTextColor)
            toolbarLayout.circularReveal(backgroundColor)
            toolbarLayout.setContentScrimColor(backgroundColor)
        }
    }


    override fun getLayoutId() = R.layout.activity_user_detail

    override fun getViewModel() = UserDetailViewModel::class.java

}