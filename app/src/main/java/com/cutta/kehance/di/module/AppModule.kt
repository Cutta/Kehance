package com.cutta.kehance.di.module

import android.content.Context
import com.cutta.kehance.KehanceApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by CuneytCarikci on 10/01/2018.
 */

@Module(includes = [(ViewModelModule::class)])
class AppModule{

    @Singleton
    @Provides
    fun provideApplicationContext(application: KehanceApplication): Context = application.applicationContext
}
