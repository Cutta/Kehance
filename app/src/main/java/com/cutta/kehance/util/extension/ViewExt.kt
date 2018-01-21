package com.cutta.kehance.util.extension

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Build
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewAnimationUtils
import android.view.ViewGroup
import android.widget.TextView

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

fun ViewGroup.inflate(layoutResId: Int): View =
        LayoutInflater.from(context).inflate(layoutResId, this, false)


fun TextView.setTextFromHtml(html: String) {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        this.text = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
    } else {
        @Suppress("DEPRECATION")
        this.text = Html.fromHtml(html)
    }
}


fun View.circularReveal(backgroundColor: Int) {
    val showAndSetBackgroundColorFunction = {
        this.setBackgroundColor(backgroundColor)
        this.visibility = View.VISIBLE
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        this.post {
            val cx = this.width / 2
            val cy = this.height / 2
            val finalRadius = Math.hypot(cx.toDouble(), cy.toDouble()).toFloat()

            try {
                val animator = ViewAnimationUtils.createCircularReveal(this, cx, cy, 0f, finalRadius)
                animator.startDelay = 50
                animator.addListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationStart(animation: Animator?) {
                        showAndSetBackgroundColorFunction.invoke()
                    }
                })
                animator.start()
            } catch (e: Exception) {
                Log.d("Exception", e.message)
            }
        }
    } else {
        showAndSetBackgroundColorFunction.invoke()
    }
}


