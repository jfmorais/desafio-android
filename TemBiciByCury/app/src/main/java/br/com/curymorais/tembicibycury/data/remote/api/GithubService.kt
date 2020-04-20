package br.com.curymorais.tembicibycury.data.remote.api

import br.com.curymorais.tembicibycury.data.local.GitPulls
import br.com.curymorais.tembicibycury.data.remote.model.GitApiResponse
import br.com.curymorais.tembicibycury.data.remote.model.GitPullResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET("search/repositories")
    suspend fun getRepos(@Query("language") language: String?, @Query("sort") sort: String?, @Query("order") order: String?): GitApiResponse

    @GET("search/repositories")
    suspend fun getReposKot(@Query("sort") sort: String?): GitApiResponse


    @GET("search/repositories?q=language:Java&sort=stars")
    suspend fun getReposByPage(@Query ("page") page: Long): GitApiResponse

    @GET("repos/{user_id}/{repo_id}/pulls")
    suspend fun getPullsFromRepo(@Path("user_id") userId : String, @Path("repo_id") repoId : String): List<GitPulls>

    @GET("https://api.github.com/repos/octocat/Hello-World/pulls")
    suspend fun getPullsFromRepo2(): List<GitPulls>

}