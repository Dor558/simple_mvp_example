package com.example.simple_mvp_example

import com.example.simple_mvp_example.application.AppComponents
import com.example.simple_mvp_example.base.BaseViewModel
import com.example.simple_mvp_example.github.GithubPresenter
import com.example.simple_mvp_example.github.GithubViewModel
import com.example.simple_mvp_example.github.ui.GithubView


class MainActivityComponents {

    companion object {

        fun inject(mainActivity: MainActivity) {
            val githubRepository = AppComponents.getInstance().githubRepository
            val githubViewModel = BaseViewModel.provideViewModel(
                mainActivity,
                GithubViewModel::class.java
            ) { GithubViewModel(githubRepository) }
            mainActivity.githubPresenter = GithubPresenter(mainActivity, GithubView(mainActivity) ,githubViewModel)

        }
    }

}