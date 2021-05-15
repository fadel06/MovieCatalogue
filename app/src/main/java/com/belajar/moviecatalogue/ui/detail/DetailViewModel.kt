package com.belajar.moviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.belajar.moviecatalogue.data.CrewEntity
import com.belajar.moviecatalogue.data.ItemEntity
import com.belajar.moviecatalogue.data.source.MovieCatalogueRepository

class DetailViewModel (private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getMovieDetail(id: Int): ItemEntity? = movieCatalogueRepository.getDetailMovie(id)

    fun getMovieCrews(movie: ItemEntity?): List<CrewEntity>? = movie?.crews

    fun getTvShowDetail(id: Int): ItemEntity? = movieCatalogueRepository.getDetailTvShow(id)

    fun getTvShowCrews(tvShow: ItemEntity?): List<CrewEntity>? = tvShow?.crews

}