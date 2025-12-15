package br.com.dev.searchapp.helpers

import android.content.Context
import android.content.Intent

object ShareHelper {

    fun shareLink(context: Context, url: String) {
        val sendIntent = Intent(Intent.ACTION_SEND).apply {
            putExtra(Intent.EXTRA_TEXT, url)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, "Compartilhar repositório")
        context.startActivity(shareIntent)
    }
}