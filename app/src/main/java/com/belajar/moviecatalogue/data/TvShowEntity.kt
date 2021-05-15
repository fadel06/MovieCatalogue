package com.belajar.moviecatalogue.data

data class TvShowEntity(
    val tvShowId: Int?,
    val tvShowTitle: String?,
    val tvShowDescription: String?,
    val tvShowPoster : Int?,
    val tvShowRelease: String?,
    val tvShowRating : String?,
    val tvShowTrailer : String?,
    val crews: List<CrewEntity>
)