package br.com.curymorais.tembicibycury.reposPullDetail

import androidx.lifecycle.*
import br.com.curymorais.tembicibycury.data.GitRepository
import kotlinx.coroutines.Dispatchers

class DetailPullRepoViewModel(u: String, r: String) : ViewModel(){

    var user =  u
    var repo = r
    private val repository: GitRepository = GitRepository()

    val firstPage = liveData(Dispatchers.IO) {
        val retrivedTodo = repository?.getReposPulls(user, repo)
        emit(retrivedTodo)
    }


}