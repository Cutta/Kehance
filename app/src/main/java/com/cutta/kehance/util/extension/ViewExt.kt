package com.cutta.kehance.util.extension

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by CuneytCarikci on 13/01/2018.
 */

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

infix fun ViewGroup.inflate(layoutResId: Int): View =
        LayoutInflater.from(context).inflate(layoutResId, this, false)


fun ImageView.load(url: String?) {
    url?.let {
        Glide.with(this).load(url).into(this)
    } ?: setImageBitmap(null)

}
