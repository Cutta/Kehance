package com.cutta.kehance.ui.detail

import android.view.View
import com.cutta.kehance.data.remote.model.CommentItem
import com.cutta.kehance.ui.base.BaseAdapter

/**
 * Created by CuneytCarikci on 19/01/2018.
 */

class CommentListAdapter(items: List<CommentItem> = ArrayList(),
                         layoutResId: Int,
                         val listener: CommentClickListener,
                         private val bindHolder: View.(CommentItem) -> Unit)
    : BaseAdapter<CommentItem>(items, layoutResId) {


    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = itemList[holder.adapterPosition]
        with(holder.itemView) {
            setOnClickListener { listener.onCommentClick(item) }
            bindHolder(itemList[holder.adapterPosition])
        }
    }

    interface CommentClickListener {
        fun onCommentClick(item: CommentItem)
        //fun onUserClick(item: CommentItem)
    }
}