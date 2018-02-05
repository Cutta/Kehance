package com.cutta.kehance.ui.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.cutta.kehance.R
import com.cutta.kehance.data.remote.model.ProjectItem
import com.cutta.kehance.ui.base.BaseActivity
import com.cutta.kehance.ui.detail.DetailActivity
import com.cutta.kehance.util.extension.alert
import com.cutta.kehance.util.extension.isPortrait
import com.cutta.kehance.util.extension.load
import com.cutta.kehance.util.extension.reObserve
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_project.view.*


class MainActivity : BaseActivity<MainViewModel>(), ProjectListAdapter.ProjectClickListener {

    private lateinit var projectsAdapter: ProjectListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setToolBar()
        initViews()
        observeViewModel()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        return true
    }


    private fun openSearchActivity() {
        Log.d("TAG", "openSearchActivity")
    }

    private fun setToolBar() {
        setSupportActionBar(toolbar)
    }

    private fun observeViewModel() {
        swipeRefreshLayout.isRefreshing = true
        viewModel.projects.reObserve(this, Observer {
            it?.projects.let {
                projectsAdapter.update(it)
                swipeRefreshLayout.isRefreshing = false
            }
        })

        viewModel.errorLiveData.observe(this, Observer {
            alert {
                setTitle(it?.message)
                setPositiveButton(R.string.dialog_ok, null)
            }
            swipeRefreshLayout.isRefreshing = false
        })

    }

    private fun initViews() {

        swipeRefreshLayout.setOnRefreshListener {
            observeViewModel()
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
            layoutManager = GridLayoutManager(this@MainActivity, if (isPortrait()) 2 else 3)
            setHasFixedSize(true)
            adapter = projectsAdapter
            scheduleLayoutAnimation()
        }

    }

    override fun onProjectClick(item: ProjectItem) {
        startActivity(DetailActivity.getIntent(this, item.id, item.name))
    }

    override fun getLayoutId() = R.layout.activity_main

    override fun getViewModel() = MainViewModel::class.java

}
