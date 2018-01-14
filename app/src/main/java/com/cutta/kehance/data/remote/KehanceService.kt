package com.cutta.kehance.data.remote

import com.cutta.kehance.data.remote.model.ProjectDetail
import com.cutta.kehance.data.remote.model.ProjectItem
import com.cutta.kehance.data.remote.model.ProjectList
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by CuneytCarikci on 10/01/2018.
 */

interface KehanceService {

    @GET("projects")
    fun getProjects(@Query("api_key") apiKey: String): Single<ProjectList>

    @GET("projects/{project_id}")
    fun getProjectWithId(@Path(value = "project_id") id: String, @Query("api_key") apiKey: String): Single<ProjectDetail>

}