package com.cutta.kehance.util.extension

import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.cutta.kehance.util.TransformationType

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


fun ImageView.load(url: String?, requestOptions: TransformationType = TransformationType.DEFAULT) {
    url?.let {
        Glide.with(this)
                .load(url)
                .apply(requestOptions.getTransformation())
                .into(this)
    } ?: setImageBitmap(null)

}

fun TextView.setTextFromHtml(html: String) {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        this.text = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
    } else {
        @Suppress("DEPRECATION")
        this.text = Html.fromHtml(html)
    }
}


