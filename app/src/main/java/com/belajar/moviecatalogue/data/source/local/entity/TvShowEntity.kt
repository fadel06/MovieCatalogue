package com.belajar.moviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.*

@Entity (tableName = "tvShowEntities")
data class TvShowEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "poster")
    val poster: String,

    @ColumnInfo(name = "release")
    val release: String,

    @ColumnInfo(name = "rating")
    val rating: String,

    @ColumnInfo(name = "trailer")
    val trailer: String,

    @ColumnInfo(name = "crewEntity")
    val crewEntity: List<CrewEntity>,

    @ColumnInfo (name = "isFavorite")
    var isFavorite: Boolean = false
)
