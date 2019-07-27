package com.example.simple_mvp_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simple_mvp_example.application.AppComponents
import com.example.simple_mvp_example.application.GithubApplication
import com.example.simple_mvp_example.base.BaseViewModel
import com.example.simple_mvp_example.github.GithubContract
import com.example.simple_mvp_example.github.GithubPresenter
import com.example.simple_mvp_example.github.GithubViewModel
import com.example.simple_mvp_example.github.UserGithubRepository
import com.example.simple_mvp_example.github.ui.GithubView

class MainActivity : AppCompatActivity() {

    internal lateinit var githubPresenter: GithubContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MainActivityComponents.inject(this)
    }
}
