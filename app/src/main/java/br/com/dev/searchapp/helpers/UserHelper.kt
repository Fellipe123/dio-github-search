package br.com.dev.searchapp.helpers

import br.com.dev.searchapp.data.UserPreferences

object UserHelper {

    fun saveUser(prefs: UserPreferences, user: String) {
        prefs.saveUser(user)
    }

    fun loadUser(prefs: UserPreferences): String? {
        return prefs.getUser()
    }
}