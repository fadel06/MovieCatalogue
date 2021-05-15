package com.belajar.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.belajar.moviecatalogue.data.CrewEntity
import com.belajar.moviecatalogue.data.ItemEntitySameWithResponse
import com.belajar.moviecatalogue.data.source.MovieCatalogueRepository

class DetailViewModel (private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getMovieDetail(id: Int): LiveData<ItemEntitySameWithResponse?> = movieCatalogueRepository.getDetailMovie(id)

    fun getMovieCrews(movie: ItemEntitySameWithResponse?): List<CrewEntity>? = movie?.crews

    fun getTvShowDetail(id: Int): LiveData<ItemEntitySameWithResponse?> = movieCatalogueRepository.getDetailTvShow(id)

    fun getTvShowCrews(tvShow: ItemEntitySameWithResponse?): List<CrewEntity>? = tvShow?.crews

}