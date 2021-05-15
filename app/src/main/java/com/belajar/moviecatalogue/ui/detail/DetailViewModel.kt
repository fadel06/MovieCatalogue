package com.belajar.moviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.belajar.moviecatalogue.data.CrewEntity
import com.belajar.moviecatalogue.data.MovieEntity
import com.belajar.moviecatalogue.data.TvShowEntity
import com.belajar.moviecatalogue.utils.Data

class DetailViewModel : ViewModel() {

    fun getMovieDetail(id: Int): MovieEntity? = Data.movieDetail(id)

    fun getMovieCrews(movie: MovieEntity?): List<CrewEntity>? = movie?.crews

    fun getTvShowDetail(id: Int): TvShowEntity? = Data.tvShowDetail(id)

    fun getTvShowCrews(tvShow: TvShowEntity?): List<CrewEntity>? = tvShow?.crews

}