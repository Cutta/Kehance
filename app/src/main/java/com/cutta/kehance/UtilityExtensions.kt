package com.cutta.kehance

/**
 * Created by CuneytCarikci on 10/01/2018.
 */

inline fun debug(body: () -> Unit) {
    if (BuildConfig.DEBUG)
        body()
}