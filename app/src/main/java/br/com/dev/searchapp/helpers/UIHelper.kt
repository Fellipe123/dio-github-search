package br.com.dev.searchapp.helpers

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import br.com.dev.searchapp.domain.Repository
import br.com.dev.searchapp.ui.adapter.RepositoryAdapter

object UIHelper {

    lateinit var recycler: RecyclerView

    fun setup(recyclerView: RecyclerView) {
        recycler = recyclerView
    }

    fun updateList(context: Context, list: List<Repository>) {
        val adapter = RepositoryAdapter(list)

        adapter.cardItemListener = { repo ->
            BrowserHelper.openBrowser(context, repo.htmlUrl)
        }

        adapter.btnShareListener = { repo ->
            ShareHelper.shareLink(context, repo.htmlUrl)
        }

        recycler.adapter = adapter
    }
}