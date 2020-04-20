package br.com.curymorais.tembicibycury.detailpullrepo

import androidx.lifecycle.*
import br.com.curymorais.tembicibycury.data.GitRepository
import br.com.curymorais.tembicibycury.data.remote.model.GitApiResponse
import br.com.curymorais.tembicibycury.data.remote.model.GitPullResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailPullRepoViewModel(u: String, r: String) : ViewModel(){

    var user =  u
    var repo = r
    private val repository: GitRepository = GitRepository()

    val firstPage = liveData(Dispatchers.IO) {
        val retrivedTodo = repository?.getReposPulls(user, repo)
        emit(retrivedTodo)
    }


}