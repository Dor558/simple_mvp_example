package com.example.simple_mvp_example.github

import androidx.lifecycle.MutableLiveData
import com.example.simple_mvp_example.github.GithubContract.ViewModel.State
import com.example.simple_mvp_example.base.BaseViewModel
import com.example.simple_mvp_example.models.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers


class GithubViewModel(private val userGithubRepository: GithubContract.Repository)
    : BaseViewModel(), GithubContract.ViewModel {

    override val state: MutableLiveData<State> = MutableLiveData()

    init {
        fetchGithubRepositories()
    }

    override fun fetchGithubRepositories() {
        addSubscription(
            userGithubRepository.fetchGithubRepositories(User("dor558"))
                .doOnSubscribe {
                    state.postValue(State.Pending)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onSuccess = {
                        state.value = State.Displaying(it)
                    },
                    onError = {
                        state.value = State.Error(it)
                    }
                )
        )
    }
}