package com.example.simple_mvp_example.github.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simple_mvp_example.R
import com.example.simple_mvp_example.models.GithubRepository
import kotlinx.android.synthetic.main.github_repo_view_holder.view.*


class GithubAdapter(context: Context): RecyclerView.Adapter<GithubAdapter.GithubRepositoryViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)
    private var itemsList = mutableListOf<GithubRepository>()


    fun setItems(items: List<GithubRepository>) {
        itemsList.clear()
        itemsList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubRepositoryViewHolder {
        val view = layoutInflater.inflate(R.layout.github_repo_view_holder, parent, false)
        return GithubRepositoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(holder: GithubRepositoryViewHolder, position: Int) {
        val githubRepository = itemsList[position]
        holder.itemView.text_view_repo_name.text = githubRepository.name
    }


    inner class GithubRepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}