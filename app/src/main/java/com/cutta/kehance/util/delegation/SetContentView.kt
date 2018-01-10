package com.cutta.kehance.util.delegation

import android.app.Activity
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Created by CuneytCarikci on 10/01/2018.

class SetContentView<in R : Activity, out VDB : ViewDataBinding>(@LayoutRes private val layoutRes: Int) : ReadOnlyProperty<R, VDB> {

    private var value: VDB? = null

    override fun getValue(thisRef: R, property: KProperty<*>): VDB {
        value = value ?: DataBindingUtil.setContentView(thisRef, layoutRes)
        return value!!
    }
}

fun <T : Activity, R : ViewDataBinding> contentView(@LayoutRes layoutRes: Int): SetContentView<T, R> {
    return SetContentView(layoutRes)
} */