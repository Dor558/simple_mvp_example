package com.example.simple_mvp_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simple_mvp_example.application.GithubApplication
import com.example.simple_mvp_example.base.BaseViewModel
import com.example.simple_mvp_example.github.GithubPresenter
import com.example.simple_mvp_example.github.GithubViewModel
import com.example.simple_mvp_example.github.ui.GithubView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initGithubView()
    }

    private fun initGithubView() {
        val githubRepository = (this.application as GithubApplication).userGithubRepository
        val githubViewModel = BaseViewModel.provideViewModel(
            this,
            GithubViewModel::class.java
        ) { GithubViewModel(githubRepository) }
        GithubPresenter(this, GithubView(this) ,githubViewModel)
    }
}
