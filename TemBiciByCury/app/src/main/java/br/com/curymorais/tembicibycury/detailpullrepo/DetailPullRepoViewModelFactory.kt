package br.com.curymorais.tembicibycury.detailpullrepo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class DetailPullRepoViewModelFactory(private val user: String, private val repo: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailPullRepoViewModel::class.java)) {
            return DetailPullRepoViewModel(user, repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}