package br.com.curymorais.tembicibycury.data

import android.util.Log
import br.com.curymorais.tembicibycury.data.local.GitPulls
import br.com.curymorais.tembicibycury.data.remote.api.GithubService
import br.com.curymorais.tembicibycury.data.remote.model.GitApiResponse
import br.com.curymorais.tembicibycury.data.remote.model.GitPullResponse
import br.com.curymorais.tembicibycury.util.RetrofitInitializer
import java.lang.Exception

class GitRepository{

    var gitRepos: GithubService = RetrofitInitializer().webservice

    suspend fun getRepos() = gitRepos.getRepos("kotlin","stars","desc")
    suspend fun getReposKot() = gitRepos.getReposKot("stars")

    suspend fun getReposByPage(pageNumber :Long) : GitApiResponse {
       var repos =  gitRepos.getReposByPage(pageNumber)
        Log.i("Cury", repos.incomplete_results.toString())
        return repos
    }

    suspend fun getReposPulls(user: String, repo: String) : List<GitPulls> {

//        try {
//            var repos = gitRepos.getPullsFromRepo2()
            var repos =  gitRepos.getPullsFromRepo(user, repo)
            Log.i("Cury", repos.toString())
            return repos
//        }catch (e : Exception) {
//            Log.i("CURY", e.toString())
//        }

    }
}
