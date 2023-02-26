package com.alvarogm.apisremotas.data.local.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.*

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
val LANGUAGE = stringPreferencesKey("language")

class SettingsDatasource constructor(private val applicationContext: Context){
    suspend fun setLanguage(idiom: Unit) {
        applicationContext.dataStore.edit { settings ->
            val currentValue = settings[LANGUAGE] ?: "en"
            settings[LANGUAGE] =  idiom.toString()
        }
    }
    fun getLanguage1(): Flow<String> {
        val myLanguage: Flow<String> = applicationContext.dataStore.data
            .map { settings ->
                // No type safety.
                settings[LANGUAGE] ?: ""
            }
        return myLanguage
    }

    fun getLanguage(){
        applicationContext.dataStore.data.map { settings ->
                Setting(
                    language = settings[LANGUAGE].orEmpty()
                )
            }

    }

}
