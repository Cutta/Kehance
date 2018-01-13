package com.cutta.kehance.util.extension

import android.app.Activity
import android.content.res.Configuration

/**
 * Created by CuneytCarikci on 13/01/2018.
 */

fun Activity.isPortrait() = this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT