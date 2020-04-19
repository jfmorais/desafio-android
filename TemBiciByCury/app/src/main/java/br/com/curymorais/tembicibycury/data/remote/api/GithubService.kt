package br.com.curymorais.tembicibycury.data.remote.api

import br.com.curymorais.tembicibycury.data.remote.model.GitApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {

    @GET("search/repositories")
    suspend fun getRepos(@Query("language") language: String?, @Query("sort") sort: String?, @Query("order") order: String?): GitApiResponse

    @GET("search/repositories")
    suspend fun getReposKot(@Query("sort") sort: String?): GitApiResponse


    @GET("search/repositories?q=language:Java&sort=stars")
    suspend fun getReposByPage(@Query ("page") page: Long): GitApiResponse

    @GET("repos/<criador>/<repositório>/pulls")
    suspend fun getPullsFromRepo(@Query ("page") page: Long): GitApiResponse
}