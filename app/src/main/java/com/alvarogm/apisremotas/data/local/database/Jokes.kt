package com.alvarogm.apisremotas.data.local.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alvarogm.apisremotas.data.remote.Flags
import com.alvarogm.apisremotas.data.remote.JokeClass

@Entity
data class Jokes (
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "joke") val joke:String
)


