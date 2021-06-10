package com.belajar.moviecatalogue.ui.movieandtvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.belajar.moviecatalogue.data.ItemEntitySameWithResponse
import com.belajar.moviecatalogue.data.source.MovieCatalogueRepository

class MovieAndTvShowViewModel (private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel()  {

    fun getMovies(): LiveData<List<ItemEntitySameWithResponse>> = movieCatalogueRepository.getAllMovies()

    fun getTvShows(): LiveData<List<ItemEntitySameWithResponse>> =
        movieCatalogueRepository.getAllTvShows()
}