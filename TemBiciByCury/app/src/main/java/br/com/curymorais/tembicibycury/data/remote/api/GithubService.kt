package com.curymorais.gittopreposbycury.data.remote.api

import com.curymorais.gittopreposbycury.data.remote.model.GitApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {

    @GET("search/repositories")
    suspend fun getRepos(@Query("language") language: String?,
        @Query("sort") sort: String?,
        @Query("order") order: String?
    ): GitApiResponse

    @GET("search/repositories")
    suspend fun getReposKot(@Query("sort") sort: String?): GitApiResponse


    @GET("search/repositories?q=language:kotlin&sort=stars")
    suspend fun getReposByPage(@Query ("page") page: Long): GitApiResponse


}