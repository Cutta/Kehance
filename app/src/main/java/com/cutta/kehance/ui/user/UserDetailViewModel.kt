package com.cutta.kehance.ui.user

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import com.cutta.kehance.data.remote.model.UserInfo
import com.cutta.kehance.data.remote.model.UsersItem
import com.cutta.kehance.data.repository.KehanceRepository
import com.cutta.kehance.ui.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by CuneytCarikci on 22/01/2018.
 */

class UserDetailViewModel @Inject constructor(kehanceRepository: KehanceRepository) : BaseViewModel() {


    private val userId: MutableLiveData<Int> = MutableLiveData()

    val userDetails: LiveData<UserInfo>

    init {
        userDetails = Transformations.switchMap(userId) {
            LiveDataReactiveStreams.fromPublisher(kehanceRepository.getUser(userId.value!!))
        }
    }


    fun setUserId(id: Int) {
        this.userId.value = id
    }


}