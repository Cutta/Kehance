package com.cutta.kehance.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.cutta.kehance.data.remote.model.ProjectList
import com.cutta.kehance.data.repository.KehanceRepository
import com.cutta.kehance.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import javax.inject.Inject

/**
 * Created by CuneytCarikci on 10/01/2018.
 */

class MainViewModel @Inject constructor(kehanceRepository: KehanceRepository) : BaseViewModel() {

    private val projectsLiveData = MutableLiveData<ProjectList>()

    val projects: LiveData<ProjectList>
        get() = projectsLiveData

    init {
        disposables.add(kehanceRepository.getProjects()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        projectsLiveData::setValue
                        ,
                        {
                            errorLiveData.value = it
                        }))
    }


}