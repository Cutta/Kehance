package com.cutta.kehance.data.repository

import com.cutta.kehance.BuildConfig
import com.cutta.kehance.data.remote.KehanceService
import com.cutta.kehance.data.remote.model.*
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by CuneytCarikci on 10/01/2018.
 */

@Singleton
class KehanceRepository @Inject constructor(private val service: KehanceService) {


    fun getProjects(): Flowable<ProjectList> =
            service.getProjects(BuildConfig.API_KEY)
                    .subscribeOn(Schedulers.newThread())
                    .toFlowable()


    fun getProjectWithId(id: Int): Flowable<ProjectDetail> =
            service.getProjectWithId(id, BuildConfig.API_KEY)
                    .subscribeOn(Schedulers.newThread())
                    .toFlowable()

    fun getComments(id: Int): Flowable<Comments> =
            service.getComments(id, BuildConfig.API_KEY)
                    .subscribeOn(Schedulers.newThread())
                    .toFlowable()

    fun getUser(id: Int): Flowable<UserInfo> =
            service.getUser(id, BuildConfig.API_KEY)
                    .subscribeOn(Schedulers.newThread())
                    .toFlowable()

    fun getUserProjects(id: Int): Flowable<ProjectList> =
            service.getUserProject(id, BuildConfig.API_KEY)
                    .subscribeOn(Schedulers.newThread())
                    .toFlowable()

}