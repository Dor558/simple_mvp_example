package com.example.simple_mvp_example.application

import android.app.Application
import com.example.simple_mvp_example.github.GithubContract
import com.example.simple_mvp_example.github.GithubInteractor
import com.example.simple_mvp_example.github.NetworkSource
import com.example.simple_mvp_example.github.UserGithubRepository
import com.example.simple_mvp_example.network.NetworkApi
import com.example.simple_mvp_example.network.NetworkClient
import com.squareup.leakcanary.LeakCanary


class GithubApplication : Application() {

    lateinit var appComponents: AppComponents

    override fun onCreate() {
        super.onCreate()
        appComponents = AppComponents.getInstance()
        LeakCanary.install(this)
    }

}