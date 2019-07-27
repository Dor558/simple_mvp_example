package com.example.simple_mvp_example.network

import com.example.simple_mvp_example.network.api.GithubApi


class NetworkApi(networkClient: NetworkContract.Client): NetworkContract.NetworkApi {

    override val githubApi: GithubApi = networkClient.client.create(GithubApi::class.java)
}