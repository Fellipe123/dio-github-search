package br.com.dev.searchapp.controller

import android.content.Context
import android.widget.EditText
import br.com.dev.searchapp.data.UserPreferences

class UserController(private val context: Context) {

    private val prefs = UserPreferences(context)

    fun saveUser(user: String) {
        prefs.saveUser(user)
    }

    fun loadUserToField(editText: EditText) {
        prefs.getUser()?.let { saved ->
            editText.setText(saved)
        }
    }
}