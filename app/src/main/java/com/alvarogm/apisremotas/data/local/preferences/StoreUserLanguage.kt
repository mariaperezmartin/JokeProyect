package com.alvarogm.apisremotas.data.local.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreUserLanguage(private val context: Context) {

    // to make sure there is only one instance
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("UserLanguage")
        val USER_EMAIL_KEY = stringPreferencesKey("user_language")
    }

    // to get the email
    val getLanguage: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[USER_EMAIL_KEY] ?: ""
        }

    // to save the email
    suspend fun saveLanguage(name: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_EMAIL_KEY] = name
        }
    }
}