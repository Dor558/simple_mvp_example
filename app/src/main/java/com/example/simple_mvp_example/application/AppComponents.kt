package com.example.simple_mvp_example.application

import com.example.simple_mvp_example.github.GithubContract
import com.example.simple_mvp_example.github.GithubInteractor
import com.example.simple_mvp_example.github.NetworkSource
import com.example.simple_mvp_example.github.UserGithubRepository
import com.example.simple_mvp_example.network.NetworkApi
import com.example.simple_mvp_example.network.NetworkClient
import com.example.simple_mvp_example.network.NetworkContract


class AppComponents private constructor(){

    val networkApi: NetworkContract.NetworkApi
    val githubRepository: GithubContract.Repository

    init {
        networkApi = NetworkApi(NetworkClient())
        githubRepository = UserGithubRepository(GithubInteractor(NetworkSource(networkApi)))
    }

    companion object {

        private var instance: AppComponents? = null

        @Synchronized
        fun getInstance(): AppComponents {
            if (instance == null) {
                instance = AppComponents()
            }

            return instance!!
        }
    }

}