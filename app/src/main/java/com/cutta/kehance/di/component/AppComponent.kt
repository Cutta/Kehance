package com.cutta.kehance.di.component

import com.cutta.kehance.KehanceApplication
import com.cutta.kehance.di.module.ActivityBuilderModule
import com.cutta.kehance.di.module.AppModule
import com.cutta.kehance.di.module.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by CuneytCarikci on 10/01/2018.
 */


@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    NetworkModule::class,
    ActivityBuilderModule::class])
interface AppComponent : AndroidInjector<KehanceApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<KehanceApplication>()
}
