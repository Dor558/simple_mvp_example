package com.example.simple_mvp_example.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

interface RxComponent {

    val disposables: CompositeDisposable

    fun addSubscription(subscription: Disposable) {
        disposables.add(subscription)
    }
}
