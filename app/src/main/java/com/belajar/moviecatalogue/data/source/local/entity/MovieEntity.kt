package com.belajar.moviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "movieEntities")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "poster")
    var poster : String,

    @ColumnInfo(name = "release")
    var release: String,

    @ColumnInfo(name = "rating")
    var rating : String,

    @ColumnInfo(name = "trailer")
    var trailer : String,

    @ColumnInfo(name = "crewEntity")
    var crewEntity: List<CrewEntity>,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)
