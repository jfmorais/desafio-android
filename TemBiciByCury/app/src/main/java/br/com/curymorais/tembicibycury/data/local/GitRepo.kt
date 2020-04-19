package com.curymorais.gittopreposbycury.data.local

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
////
//@Entity
//data class GitRepo(
//    @PrimaryKey
//    var id: Long?,
//    val page: Long,
//    val totalPages: Long,
//    val name: String?,
//    @SerializedName("full_name")
//    val fullName: String?,
//    @Embedded
//    val gitRepoOwner: GitRepoOwner,
//    @SerializedName("html_url")
//    val htmlUrl: String?,
//    val description: String?,
//    @SerializedName("contributors_url")
//    val contributorsUrl: String?,
//    @SerializedName("created_at")
//    val createdAt: String?,
//    @SerializedName("stargazers_count")
//    val starsCount: Long?,
//    val watchers: Long?,
//    val forks: Long?,
//    val language: String?
//)

//data class GitRepo(
//    var id: Long,
//    val page: Long,
//    val totalPages: Long,
//    val name: String,
//    val fullName: String,
//    val owner: GitRepoOwner,
//    val htmlUrl: String,
//    val description: String,
//    val contributorsUrl: String,
//    val createdAt: String,
//    val starsCount: Long,
//    val watchers: Long,
//    val forks: Long?,
//    val language: String
//)

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
