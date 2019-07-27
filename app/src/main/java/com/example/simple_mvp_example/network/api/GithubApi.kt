package com.example.simple_mvp_example.network.api

import com.example.simple_mvp_example.models.GithubRepository
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubApi {

    @GET("/users/{user}/repos")
    fun getUserGithubRepositories(@Path("user") user: String): Single<List<GithubRepository>>

}
