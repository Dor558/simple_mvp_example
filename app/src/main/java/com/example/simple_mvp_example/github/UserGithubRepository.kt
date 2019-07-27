package com.example.simple_mvp_example.github

import com.example.simple_mvp_example.models.GithubRepository
import com.example.simple_mvp_example.models.User
import io.reactivex.Single
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers


class UserGithubRepository(private val githubInteractor: GithubContract.Interactor) :
    GithubContract.Repository {

    override fun fetchGithubRepositories(user: User): Single<List<GithubRepository>> {
        return Single.create { emitter ->
            githubInteractor.getGithubRepositories(user)
                .subscribeOn(Schedulers.io())
                .subscribeBy(
                    onError = {
                        emitter.onError(it)
                    },
                    onSuccess = {
                        emitter.onSuccess(it)
                    }
                )
        }
    }
}