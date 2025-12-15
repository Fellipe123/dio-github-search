package br.com.dev.searchapp.data

import android.content.Context
import androidx.core.content.edit

class UserPreferences(context: Context) {

    private val prefs = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    fun saveUser(user: String) {
        prefs.edit { putString("user", user) }
    }

    fun getUser(): String? = prefs.getString("user", null)
}