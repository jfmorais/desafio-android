package br.com.curymorais.tembicibycury.data.local

data class GitPulls (
    var id: Long,
    var title: String,
    var created_at: String,
    var body: String,
    var user: GitPullOwner
)