package com.example.simple_mvp_example.github

import com.example.simple_mvp_example.models.GithubRepository
import com.example.simple_mvp_example.models.User
import io.reactivex.Single
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers


class UserGithubRepository(private val githubInteractor: GithubContract.Interactor) :
    GithubContract.Repository {


    companion object {

        var userGithubRepository: GithubContract.Repository? = null
        private set

        @Synchronized
        fun setup(githubInteractor: GithubContract.Interactor): GithubContract.Repository {
            if (userGithubRepository == null) {
                userGithubRepository = UserGithubRepository(githubInteractor)
            }

            return userGithubRepository!!
        }

        fun getInstance() : GithubContract.Repository {
            return userGithubRepository ?: throw Throwable("Uninitialized yet, call setup")
        }
    }


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