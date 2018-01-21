package com.cutta.kehance.ui.detail

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import com.cutta.kehance.data.remote.model.Comments
import com.cutta.kehance.data.remote.model.ProjectDetail
import com.cutta.kehance.data.repository.KehanceRepository
import com.cutta.kehance.ui.base.BaseViewModel
import javax.inject.Inject


/**
 * Created by CuneytCarikci on 13/01/2018.
 */

class DetailViewModel @Inject constructor(kehanceRepository: KehanceRepository) : BaseViewModel() {

    private val projectId: MutableLiveData<Int> = MutableLiveData()
    val details: LiveData<ProjectDetail>
    val comments: LiveData<Comments>

    init {
        details = Transformations.switchMap(projectId) {
            LiveDataReactiveStreams.
                    fromPublisher(kehanceRepository.getProjectWithId(projectId.value!!))
        }
        comments = Transformations.switchMap(projectId) {
            LiveDataReactiveStreams
                    .fromPublisher(kehanceRepository.getComments(projectId.value!!))
        }
    }

    fun setProjectId(projectId: Int) {
        this.projectId.value = projectId
    }
}