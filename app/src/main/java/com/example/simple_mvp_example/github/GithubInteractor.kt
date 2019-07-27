package com.example.simple_mvp_example.github

import com.example.simple_mvp_example.models.GithubRepository
import com.example.simple_mvp_example.models.User
import io.reactivex.Single


class GithubInteractor(private val networkSource: GithubContract.Source.NetworkSource) :
    GithubContract.Interactor {

    override fun getGithubRepositories(user: User): Single<List<GithubRepository>> {
        return networkSource.fetchGithubRepositories(user)
    }
}