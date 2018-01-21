package com.cutta.kehance.util.extension

import android.content.res.Resources

/**
 * Created by CuneytCarikci on 19/01/2018.
 */

val Int.toDp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()