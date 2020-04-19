package com.curymorais.gittopreposbycury.topgitrepos

import androidx.lifecycle.*
import com.curymorais.gittopreposbycury.data.GitRepository
import com.curymorais.gittopreposbycury.data.remote.model.GitApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TopGitReposViewModel : ViewModel(){

    private val repository: GitRepository = GitRepository()

    var repos = MutableLiveData<GitApiResponse>()

    val firstPage = liveData(Dispatchers.IO) {
        val retrivedTodo = repository.getReposByPage(1)
        emit(retrivedTodo)
    }

    fun getMoreRepos(page: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            val result =
                try {
                    val new = repository.getReposByPage(page)
                    new
                } catch (e: Exception) {
                    -1L
                }
            repos.postValue(result as GitApiResponse?)
        }
    }

}