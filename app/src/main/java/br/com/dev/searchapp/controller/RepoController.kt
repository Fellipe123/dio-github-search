package br.com.dev.searchapp.controller

import android.content.Context
import br.com.dev.searchapp.data.GitHubService
import br.com.dev.searchapp.data.RetrofitClient
import br.com.dev.searchapp.domain.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoController(
    private val context: Context
) {

    private val api: GitHubService = RetrofitClient.githubService

    fun loadRepos(
        userName: String,
        onSuccess: (List<Repository>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        api.getAllRepositoriesByUser(userName)
            .enqueue(object : Callback<List<Repository>> {

                override fun onResponse(
                    call: Call<List<Repository>>,
                    response: Response<List<Repository>>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let { onSuccess(it) }
                    }
                }

                override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                    onError(t)
                }
            })
    }
}