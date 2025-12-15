package br.com.dev.searchapp.helpers

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri

object BrowserHelper {

    fun openBrowser(context: Context, url: String) {
        val intent = Intent(Intent.ACTION_VIEW, url.toUri())
        context.startActivity(intent)
    }
}