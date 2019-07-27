package com.example.simple_mvp_example.github

import androidx.lifecycle.LiveData
import com.example.simple_mvp_example.models.GithubRepository
import com.example.simple_mvp_example.models.User
import io.reactivex.Single


interface GithubContract {


    interface View {
        fun showUserRepositories(repositories: List<GithubRepository>)
    }

    interface Presenter

    interface ViewModel {

        val state: LiveData<State>

        fun fetchGithubRepositories()

        sealed class State {
            object Init : State()
            object Pending : State()
            data class Displaying(val githubRepositories: List<GithubRepository>): State()
            data class Error(val throwable: Throwable): State()

        }
    }

    interface Repository {
        fun fetchGithubRepositories(user: User): Single<List<GithubRepository>>
    }

    interface Interactor {
        fun getGithubRepositories(user: User): Single<List<GithubRepository>>
    }

    interface Source {

        interface NetworkSource {
            fun fetchGithubRepositories(user: User): Single<List<GithubRepository>>
        }

    }

}