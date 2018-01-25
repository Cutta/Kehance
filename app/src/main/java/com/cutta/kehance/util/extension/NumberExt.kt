package com.cutta.kehance.util.extension

import android.content.res.Resources
import android.text.format.DateFormat
import java.util.*

/**
 * Created by CuneytCarikci on 19/01/2018.
 */

val Int.toDp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()


fun Double.toDate(): CharSequence? {

    val cal = Calendar.getInstance(Locale.getDefault())
    cal.timeInMillis = this.toLong() * 1000L
    return DateFormat.format("dd MMM hh:mm", cal).toString()

}