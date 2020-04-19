package com.curymorais.gittopreposbycury.data.remote.model

import com.curymorais.gittopreposbycury.data.local.GitRepo
import com.google.gson.annotations.SerializedName

//data class GitApiResponse (
//    @SerializedName("total_count")
//    var totalCount: Long,
//    var items: ArrayList<GitRepo>
//)

data class GitApiResponse (
    var total_count: Long,
    var incomplete_results: Boolean,
    var items: ArrayList<GitRepo>
)