package br.com.dev.searchapp.controller

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.dev.searchapp.domain.Repository
import br.com.dev.searchapp.helpers.BrowserHelper
import br.com.dev.searchapp.helpers.ShareHelper
import br.com.dev.searchapp.ui.adapter.RepositoryAdapter

class UIController(
    private val context: Context,
    private val recyclerView: RecyclerView,
    private val progressView: View? = null,
    private val emptyView: View? = null,
    private val errorView: View? = null
) {

    init {
        setupRecycler()
    }

    private fun setupRecycler() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
    }

    fun showLoading() {
        progressView?.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
        emptyView?.visibility = View.GONE
        errorView?.visibility = View.GONE
    }

    fun showContent(list: List<Repository>) {
        progressView?.visibility = View.GONE
        errorView?.visibility = View.GONE

        if (list.isEmpty()) {
            recyclerView.visibility = View.GONE
            emptyView?.visibility = View.VISIBLE
        } else {
            emptyView?.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
            setList(list)
        }
    }

    fun showError() {
        progressView?.visibility = View.GONE
        recyclerView.visibility = View.GONE
        emptyView?.visibility = View.GONE
        errorView?.visibility = View.VISIBLE
    }

    private fun setList(list: List<Repository>) {
        val adapter = RepositoryAdapter(list)
        adapter.cardItemListener = { repo ->
            BrowserHelper.openBrowser(context, repo.htmlUrl)
        }
        adapter.btnShareListener = { repo ->
            ShareHelper.shareLink(context, repo.htmlUrl)
        }
        recyclerView.adapter = adapter
    }

    fun updateList(list: List<Repository>) {
        setList(list)
    }
}