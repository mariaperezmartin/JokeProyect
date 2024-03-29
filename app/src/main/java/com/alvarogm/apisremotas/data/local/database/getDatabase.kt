package com.alvarogm.apisremotas.data.local

import android.content.Context
import androidx.room.Room
import com.alvarogm.apisremotas.data.local.database.AppDatabase

private var db: AppDatabase? = null
fun getDatabase (applicationContext: Context): AppDatabase {
    if (db == null) {
        db = Room.databaseBuilder(
            applicationContext ,
            AppDatabase:: class.java, "jokes"
        ).build()
    }
    return db!!
}
fun closeDatabase () {
    db?.close()
}