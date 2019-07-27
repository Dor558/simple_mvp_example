package com.example.simple_mvp_example.github

import com.example.simple_mvp_example.models.GithubRepository
import com.example.simple_mvp_example.models.User
import com.example.simple_mvp_example.network.NetworkContract
import io.reactivex.Single


class NetworkSource(private val networkApi: NetworkContract.NetworkApi) :
    GithubContract.Source.NetworkSource {

    override fun fetchGithubRepositories(user: User): Single<List<GithubRepository>> {
        return networkApi.githubApi.getUserGithubRepositories(user = user.userId)
    }
}