package com.cutta.kehance.util.extension

import com.cutta.kehance.BuildConfig

/**
 * Created by CuneytCarikci on 10/01/2018.
 */

inline fun debug(body: () -> Unit) {
    if (BuildConfig.DEBUG)
        body()
}