package br.com.curymorais.tembicibycury.data

import android.util.Log
import br.com.curymorais.tembicibycury.data.remote.api.GithubService
import br.com.curymorais.tembicibycury.data.remote.model.GitApiResponse
import br.com.curymorais.tembicibycury.util.RetrofitInitializer

class GitRepository{

    var gitRepos: GithubService = RetrofitInitializer().webservice

    suspend fun getRepos() = gitRepos.getRepos("kotlin","stars","desc")
    suspend fun getReposKot() = gitRepos.getReposKot("stars")
    suspend fun getReposByPage(pageNumber :Long) : GitApiResponse {
       var repos =  gitRepos.getReposByPage(pageNumber)
        Log.i("Cury", repos.incomplete_results.toString())
        return repos
    }
}
