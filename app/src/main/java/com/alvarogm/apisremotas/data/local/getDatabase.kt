package com.faborjas.apicompose.data.local

import android.content.Context
import androidx.room.Room

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