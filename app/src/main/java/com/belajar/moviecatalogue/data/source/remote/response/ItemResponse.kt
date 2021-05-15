package com.belajar.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import com.belajar.moviecatalogue.data.ItemEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemResponse(
    val results: List<ItemEntity>?
) : Parcelable
