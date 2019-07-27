package com.example.simple_mvp_example.application

import android.app.Application
import com.example.simple_mvp_example.github.GithubContract
import com.example.simple_mvp_example.github.GithubInteractor
import com.example.simple_mvp_example.github.NetworkSource
import com.example.simple_mvp_example.github.UserGithubRepository
import com.example.simple_mvp_example.network.NetworkApi
import com.example.simple_mvp_example.network.NetworkClient


class GithubApplication : Application() {

    lateinit var userGithubRepository: GithubContract.Repository

    override fun onCreate() {
        super.onCreate()

        val networkClient = NetworkClient()
        val networkApi = NetworkApi(networkClient)
        val networkSource = NetworkSource(networkApi)
        val userGithubInteractor = GithubInteractor(networkSource)
        userGithubRepository = UserGithubRepository.getInstance(userGithubInteractor)
    }

}