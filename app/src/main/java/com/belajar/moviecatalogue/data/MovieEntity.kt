package com.belajar.moviecatalogue.data

data class MovieEntity (
    val movieId: Int?,
    val movieTitle: String?,
    val movieDescription: String?,
    val moviePoster : Int?,
    val movieRelease: String?,
    val movieRating : String?,
    val movieTrailer : String?,
    val crews: List<CrewEntity>
)