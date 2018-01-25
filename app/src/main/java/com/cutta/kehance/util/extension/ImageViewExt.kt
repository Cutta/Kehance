package com.cutta.kehance.util.extension

import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.support.v7.graphics.Palette
import android.widget.ImageView
import com.bumptech.glide.GenericTransitionOptions
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.cutta.kehance.R
import com.cutta.kehance.data.remote.model.ModulesItem
import com.cutta.kehance.util.TransformationType

/**
 * Created by CuneytCarikci on 18/01/2018.
 */

fun ImageView.generatePalette(listener: (Palette) -> Unit) {
    Palette.from((this.drawable as BitmapDrawable).bitmap).generate(listener)
}

fun ImageView.load(url: String?,
                   requestOptions: TransformationType = TransformationType.DEFAULT,
                   placeholder: Int = R.drawable.placeholder) {
    url?.let {
        Glide.with(this)
                .load(url)
                .apply(requestOptions.getTransformation().placeholder(placeholder))
                .into(this)
    } ?: setImageBitmap(null)

}

fun ImageView.loadWithCallback(url: String?,
                               requestOptions: TransformationType = TransformationType.DEFAULT,
                               listener: KCallback.() -> Unit) {
    url?.let {
        Glide.with(this)
                .load(url)
                .apply(requestOptions.getTransformation())
                .listener(KCallback().apply(listener))
                .into(this)

    } ?: setImageBitmap(null)

}

fun ImageView.load(module: ModulesItem) {

    val requestOptions = RequestOptions()
            .placeholder(R.drawable.placeholder)
            .override(module.dimensions.original.width, module.dimensions.original.height)
            .centerInside()

    Glide.with(this)
            .load(module.sizes.max1920)
            .apply(requestOptions)
            .transition(GenericTransitionOptions.with(android.R.anim.fade_in))
            .into(this)

}

class KCallback : RequestListener<Drawable> {


    private var onSuccess: (() -> Unit)? = null
    private var onError: (() -> Unit)? = null

    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
        onSuccess?.invoke()
        return false
    }

    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
        onError?.invoke()
        return true
    }

    fun onSuccess(function: () -> Unit) {
        this.onSuccess = function
    }

    fun onError(function: () -> Unit) {
        this.onError = function
    }
}