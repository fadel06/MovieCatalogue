package com.belajar.moviecatalogue.data.source.local.entity

import androidx.room.ColumnInfo

data class CrewEntity(
    @ColumnInfo(name = "crewName")
    val crewName: String,

    @ColumnInfo (name = "crewPosition")
    val crewPosition: String,

    @ColumnInfo (name = "crewPhoto")
    val crewPhoto: String
)