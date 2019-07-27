package com.example.simple_mvp_example.network

import com.example.simple_mvp_example.network.api.GithubApi
import retrofit2.Retrofit


interface NetworkContract  {

    companion object {

        const val BASE_URL = "https://api.github.com/"
    }

    interface Client {
        val client: Retrofit
    }

    interface NetworkApi {
        val githubApi: GithubApi
    }

}