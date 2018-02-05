package com.cutta.kehance.ui.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by CuneytCarikci on 10/01/2018.
 */

open class BaseViewModel : ViewModel() {

    var disposables = CompositeDisposable()
    val errorLiveData = MutableLiveData<Throwable>()

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}