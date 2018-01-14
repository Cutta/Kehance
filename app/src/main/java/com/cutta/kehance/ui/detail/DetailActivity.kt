package com.cutta.kehance.ui.detail

import android.arch.lifecycle.Observer
import android.os.Bundle
import com.cutta.kehance.data.remote.model.ModulesItem
import com.cutta.kehance.data.remote.model.ProjectDetail
import com.cutta.kehance.ui.base.BaseActivity
import com.cutta.kehance.util.ModuleType
import com.cutta.kehance.util.TransformationType
import com.cutta.kehance.util.extension.load
import kotlinx.android.synthetic.main.activity_detail.*
import android.support.constraint.ConstraintSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.cutta.kehance.R
import com.cutta.kehance.data.remote.model.Project
import com.cutta.kehance.util.extension.setTextFromHtml

/**
 * Created by CuneytCarikci on 13/01/2018.
 */

class DetailActivity : BaseActivity<DetailViewModel>() {

    companion object {
        const val INTENT_EXTRA_PROJECT_ID = "DetailActivity:Id"
    }

    private lateinit var project: Project


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.setProjectId(intent.getStringExtra(INTENT_EXTRA_PROJECT_ID))
        viewModel.details.observe(this, Observer { setViews(it) })
    }

    private fun initViews() {

    }

    private fun setViews(projectDetail: ProjectDetail?) {
        projectDetail?.project?.let {
            project = it
            projectName.text = it.name
            projectFields.text = it.fields.joinToString()
            likeCount.text = it.stats.appreciations.toString()
            viewsCount.text = it.stats.views.toString()
            commentCount.text = it.stats.comments.toString()
            ownerImage.load(it.owners.getOrNull(0)?.images?.jsonMember230 ?: "", TransformationType.CIRCLE)
            ownerName.text = it.owners.getOrNull(0)?.displayName ?: ""
            setContentModules(it.modules)
        }
    }

    private fun setContentModules(modules: List<ModulesItem>?) {
        if (modules == null)
            return
        var lastId = separator.id
        val set = ConstraintSet()
        var tempView: View
        for (module in modules) {
            when (module.type) {
                ModuleType.TEXT.type -> {
                    tempView = TextView(this)
                    tempView.setTextFromHtml(module.text)
                }
                ModuleType.IMAGE.type -> {
                    tempView = ImageView(this)
                    tempView.load(module.sizes.disp)
                }
                ModuleType.EMBED.type -> {
                    tempView = TextView(this)
                    tempView.setTextFromHtml(module.embed)
                }
                else -> {
                    tempView = TextView(this)
                    tempView.setTextFromHtml(module.text)
                }
            }

            tempView.id = module.id
            rootLayout.addView(tempView, 0)
            with(set) {
                clone(rootLayout)
                connect(tempView.id, ConstraintSet.TOP, lastId, ConstraintSet.BOTTOM, 16)
                applyTo(rootLayout)
            }
            lastId = tempView.id

        }

    }

    override fun getLayoutId(): Int = R.layout.activity_detail

    override fun getViewModel(): Class<DetailViewModel> = DetailViewModel::class.java

}