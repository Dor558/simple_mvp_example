package com.example.simple_mvp_example.github

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.simple_mvp_example.base.BasePresenter


class GithubPresenter(lifecycleOwner: LifecycleOwner,
                      view: GithubContract.View,
                      githubViewModel: GithubContract.ViewModel
)
    : BasePresenter(lifecycleOwner), GithubContract.Presenter {

    private val observer = Observer<GithubContract.ViewModel.State> { state ->
        when (state) {
            is GithubContract.ViewModel.State.Displaying -> {
                val githubRepositories = state.githubRepositories
                view.showUserRepositories(githubRepositories)
            }

            is GithubContract.ViewModel.State.Error -> {
                Log.e(this::class.java.name, state.throwable.message)
            }
        }
    }

    init {
        githubViewModel.state.observe(lifecycleOwner, observer)
    }
}