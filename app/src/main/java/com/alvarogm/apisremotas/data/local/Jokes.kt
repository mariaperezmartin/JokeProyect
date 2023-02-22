package com.alvarogm.apisremotas.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alvarogm.apisremotas.data.Flags
import com.alvarogm.apisremotas.data.JokeClass

@Entity
data class Jokes (
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "joke") val joke:String
)


