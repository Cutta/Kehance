package com.cutta.kehance.ui.main

import android.view.View
import com.cutta.kehance.data.remote.model.ProjectItem
import com.cutta.kehance.ui.base.BaseAdapter

/**
 * Created by CuneytCarikci on 13/01/2018.
 */

class ProjectListAdapter(items: List<ProjectItem> = ArrayList(),
                         layoutResId: Int,
                         val listener: ProjectClickListener,
                         private val bindHolder: View.(ProjectItem) -> Unit)
    : BaseAdapter<ProjectItem>(items, layoutResId) {

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = itemList[holder.adapterPosition]
        with(holder.itemView) {
            setOnClickListener {
                listener.onProjectClick(item)
            }
            bindHolder(itemList[holder.adapterPosition])
        }

    }

    interface ProjectClickListener {
        fun onProjectClick(item: ProjectItem)
    }

}