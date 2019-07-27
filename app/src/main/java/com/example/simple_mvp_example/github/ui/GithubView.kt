package com.example.simple_mvp_example.github.ui

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simple_mvp_example.MainActivity
import com.example.simple_mvp_example.github.GithubContract
import com.example.simple_mvp_example.models.GithubRepository
import kotlinx.android.synthetic.main.activity_main.*


class GithubView(private val activiy: MainActivity) : GithubContract.View {

    init {
        activiy.recycler_view.adapter = GithubAdapter(activiy)
        activiy.recycler_view.layoutManager = LinearLayoutManager(activiy)
    }

    override fun showUserRepositories(repositories: List<GithubRepository>) {
        (activiy.recycler_view.adapter as GithubAdapter).setItems(repositories)
    }
}