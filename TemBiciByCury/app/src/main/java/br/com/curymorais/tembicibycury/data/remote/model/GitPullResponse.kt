package br.com.curymorais.tembicibycury.data.remote.model

import br.com.curymorais.tembicibycury.data.local.GitPulls

data class GitPullResponse (
    var items: ArrayList<GitPulls>
)