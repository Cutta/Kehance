package com.cutta.kehance.ui.main

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import com.cutta.kehance.R
import com.cutta.kehance.data.remote.model.ProjectItem
import com.cutta.kehance.ui.base.BaseActivity
import com.cutta.kehance.ui.detail.DetailActivity
import com.cutta.kehance.util.extension.isPortrait
import com.cutta.kehance.util.extension.load
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_project.view.*

class MainActivity : BaseActivity<MainViewModel>(), ProjectListAdapter.ProjectClickListener {

    private lateinit var recyclerAdapter: ProjectListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        observeViewModel()

    }

    private fun observeViewModel() {
        viewModel.projects.observe(this, Observer {
            val projects = it?.projects
            projects?.let { recyclerAdapter.update(it) }
        })
    }

    private fun initViews() {

        recyclerAdapter = ProjectListAdapter(layoutResId = R.layout.item_project, listener = this) {
            projectImage.load(it.covers.jsonMember404)
            projectOwnerName.text = it.owners.getOrNull(0)?.displayName ?: ""
            projectName.text = it.name
            projectField.text = it.fields.getOrElse(0, { _ -> "" })
            projectLikeCount.text = it.stats.appreciations.toString()
            projectViewsCount.text = it.stats.views.toString()
        }

        with(projectsRecyclerView) {
            layoutManager = android.support.v7.widget.GridLayoutManager(this@MainActivity, if (isPortrait()) 2 else 3)
            setHasFixedSize(true)
            adapter = recyclerAdapter
            scheduleLayoutAnimation()
        }
    }

    override fun onProjectClick(item: ProjectItem) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.INTENT_EXTRA_PROJECT_ID, item.id.toString())
        startActivity(intent)
    }

    override fun getLayoutId() = R.layout.activity_main

    override fun getViewModel(): Class<MainViewModel> = MainViewModel::class.java

}
