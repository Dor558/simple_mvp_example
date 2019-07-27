package com.example.simple_mvp_example.base

import androidx.lifecycle.*
import io.reactivex.disposables.CompositeDisposable

interface LiveCycleAwarePresenter: LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart()

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop()

}


abstract class BasePresenter(private val lifeCycleOwner: LifecycleOwner): LiveCycleAwarePresenter, RxComponent {

    init {
       registerLifeCycle()
    }

    private fun registerLifeCycle() {
        lifeCycleOwner.lifecycle.addObserver(this)
    }

    override val disposables: CompositeDisposable = CompositeDisposable()

    override fun onCreate() {}

    override fun onStart() {}

    override fun onStop() {
        disposables.clear()
    }
}