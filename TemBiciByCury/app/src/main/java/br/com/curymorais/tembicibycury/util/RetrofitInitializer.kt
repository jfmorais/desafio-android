package com.curymorais.gittopreposbycury.util

import com.curymorais.gittopreposbycury.data.remote.api.GithubService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

//    private val retrofit = Retrofit.Builder()
//            .baseUrl(BuildConfig.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()

//    fun gitService () = retrofit.create(GithubApiService::class.java)

    val webservice: GithubService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(GithubService::class.java)
    }
}