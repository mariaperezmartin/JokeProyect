package com.alvarogm.apisremotas.data.local.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
val LANGUAGE = stringPreferencesKey("language")

class SettingsDatasource constructor(private val applicationContext: Context){
    suspend fun setLanguage() {
        applicationContext.dataStore.edit { settings ->
            val currentCounterValue = settings[LANGUAGE] ?: "en"
            settings[LANGUAGE] = currentCounterValue + 1
        }
    }
}
