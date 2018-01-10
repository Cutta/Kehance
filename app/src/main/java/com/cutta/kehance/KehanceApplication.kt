package com.cutta.kehance

import android.util.Log
import com.cutta.kehance.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by CuneytCarikci on 10/01/2018.
 */

class KehanceApplication: DaggerApplication(){

    override fun onCreate() {
        super.onCreate()
        Log.d("TAG", "onCreate")
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

}