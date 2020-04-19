package br.com.curymorais.tembicibycury.data.remote.model

import br.com.curymorais.tembicibycury.data.local.GitRepo

data class GitApiResponse (
    var total_count: Long,
    var incomplete_results: Boolean,
    var items: ArrayList<GitRepo>
)