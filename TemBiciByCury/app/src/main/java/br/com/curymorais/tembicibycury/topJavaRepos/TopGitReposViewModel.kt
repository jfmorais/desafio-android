package br.com.curymorais.tembicibycury.topJavaRepos

import androidx.lifecycle.*
import br.com.curymorais.tembicibycury.data.GitRepository
import br.com.curymorais.tembicibycury.data.remote.model.GitApiResponse
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