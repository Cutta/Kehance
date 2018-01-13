package com.cutta.kehance.di.module

import com.cutta.kehance.ui.main.MainActivity
import com.cutta.kehance.di.scope.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by CuneytCarikci on 10/01/2018.
 */

@Module
abstract class ActivityBuilderModule {
    @PerActivity
    @ContributesAndroidInjector()
    abstract fun mainActivity(): MainActivity
}