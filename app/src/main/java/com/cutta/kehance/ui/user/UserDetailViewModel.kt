package com.cutta.kehance.ui.user

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import com.cutta.kehance.data.remote.model.ProjectItem
import com.cutta.kehance.data.remote.model.ProjectList
import com.cutta.kehance.data.remote.model.UserInfo
import com.cutta.kehance.data.remote.model.UsersItem
import com.cutta.kehance.data.repository.KehanceRepository
import com.cutta.kehance.ui.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by CuneytCarikci on 22/01/2018.
 */

class UserDetailViewModel @Inject constructor(kehanceRepository: KehanceRepository) : BaseViewModel() {

    //todo required error handling
    private val userId: MutableLiveData<Int> = MutableLiveData()

    val userDetails: LiveData<UserInfo>
    val projects: LiveData<ProjectList>

    init {
        userDetails = Transformations.switchMap(userId) {
            LiveDataReactiveStreams.fromPublisher(kehanceRepository.getUser(userId.value!!))
        }

        projects = Transformations.switchMap(userId) {
            LiveDataReactiveStreams.fromPublisher(kehanceRepository.getUserProjects(userId.value!!))
        }
    }


    fun setUserId(id: Int) {
        this.userId.value = id
    }


}