package com.cutta.kehance.util.extension

import android.app.Activity
import android.content.res.Configuration
import android.os.Build
import android.support.v7.app.AlertDialog

/**
 * Created by CuneytCarikci on 13/01/2018.
 */

fun Activity.isPortrait() = this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT

inline fun Activity.alert(body: AlertDialog.Builder.() -> AlertDialog.Builder) {
    AlertDialog.Builder(this)
            .body()
            .show()
}


inline fun supportsLollipop(code: () -> Unit) {//todo where should it be??
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        code()
}