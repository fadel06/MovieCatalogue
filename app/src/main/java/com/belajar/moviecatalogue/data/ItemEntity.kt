package com.belajar.moviecatalogue.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemEntity(
    val id: Int?,
    val title: String?,
    val description: String?,
    val poster : String?,
    val release: String?,
    val rating : String?,
    val trailer : String?,
    val crews: List<CrewEntity>?
) : Parcelable
