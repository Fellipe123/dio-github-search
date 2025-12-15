package br.com.dev.searchapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.dev.searchapp.domain.Repository
import br.com.dev.searchapp.R

class RepositoryAdapter(private val repositories: List<Repository>) :
    RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    var cardItemListener: (Repository) -> Unit = {}
    var btnShareListener: (Repository) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repo = repositories[position]

        holder.repoName.text = repo.name.toString()

        holder.itemView.setOnClickListener {
            cardItemListener(repo)
        }

        holder.btnShare.setOnClickListener {
            btnShareListener(repo)
        }
    }

    override fun getItemCount(): Int = repositories.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val repoName: TextView = view.findViewById(R.id.txtRepositoryName)
        val btnShare: ImageButton = view.findViewById(R.id.btnShare)
    }

}


