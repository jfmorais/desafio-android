package br.com.curymorais.tembicibycury.data.local

data class GitRepo(
    var id: Long?,
    val name: String?,
    val full_name: String?,
    val owner: GitRepoOwner,
    val html_url: String?,
    val description: String?,
    val contributors_url: String?,
    val created_at: String?,
    val stargazers_count: Long?,
    val watchers: Long?,
    val forks: Long?,
    val language: String?
)
