package com.curymorais.gittopreposbycury.data.local

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

//@Entity
//data class GitRepoOwner(
//    val login: String,
//    @SerializedName("avatar_url")
//    val avatar: String
//)

//data class GitRepoOwner(
//    val login: String,
//    val avatar: String
//)

data class GitRepoOwner(
    val login: String,
    val avatar_url: String
)