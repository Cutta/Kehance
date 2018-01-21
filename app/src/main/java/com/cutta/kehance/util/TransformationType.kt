package com.cutta.kehance.util

import com.bumptech.glide.request.RequestOptions

/**
 * Created by CuneytCarikci on 14/01/2018.
 */

enum class TransformationType {
    CIRCLE,
    CENTER_INSIDE,
    DEFAULT;

    fun getTransformation(): RequestOptions = when (this) {
        CIRCLE -> RequestOptions().circleCrop()
        CENTER_INSIDE -> RequestOptions().centerInside()
        else -> RequestOptions().centerCrop()
    }
}