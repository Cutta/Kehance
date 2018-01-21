package com.cutta.kehance.ui.base

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.cutta.kehance.util.extension.inflate

/**
 * Created by CuneytCarikci on 13/01/2018.
 */
abstract class BaseAdapter<T> constructor(
        protected var itemList: List<T>,
        private val layoutResId: Int)
    : RecyclerView.Adapter<BaseAdapter.Holder>() {

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun getItemCount() = itemList.size

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): Holder {
        val view = parent.inflate(layoutResId)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = itemList[position]
        holder.itemView.bind(item)
    }

    protected open fun View.bind(item: T) {
    }

    fun update(itemList: List<T>?) {
        itemList?.let {
            this.itemList = itemList
            notifyDataSetChanged()
        }
    }

}