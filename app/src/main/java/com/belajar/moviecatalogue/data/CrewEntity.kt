package com.belajar.moviecatalogue.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CrewEntity(
    val crewName: String?,
    val crewPosition: String?,
    val crewPhoto: String?
) : Parcelable