package com.example.simple_mvp_example.base

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import io.reactivex.disposables.CompositeDisposable


abstract class BaseViewModel : ViewModel(), RxComponent {

    override val disposables: CompositeDisposable = CompositeDisposable()

    companion object {

        fun <T: ViewModel> provideViewModel(activity: FragmentActivity,
                                            viewModelClass: Class<T>,
                                            instance: () -> T): T {
            return ViewModelProviders.of(activity, object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return instance() as T
                }
            }).get(viewModelClass)
        }

    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}