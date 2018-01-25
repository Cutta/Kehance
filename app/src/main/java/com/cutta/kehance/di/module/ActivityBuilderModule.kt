package com.cutta.kehance.di.module

import com.cutta.kehance.ui.main.MainActivity
import com.cutta.kehance.di.scope.PerActivity
import com.cutta.kehance.ui.detail.DetailActivity
import com.cutta.kehance.ui.user.UserDetailActivity
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

    @PerActivity
    @ContributesAndroidInjector()
    abstract fun detailActivity(): DetailActivity

    @PerActivity
    @ContributesAndroidInjector()
    abstract fun userDetailActivity(): UserDetailActivity
}