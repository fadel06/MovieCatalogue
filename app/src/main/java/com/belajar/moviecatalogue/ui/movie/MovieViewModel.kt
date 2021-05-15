package com.belajar.moviecatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.belajar.moviecatalogue.data.ItemEntitySameWithResponse
import com.belajar.moviecatalogue.data.source.MovieCatalogueRepository

class MovieViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getMovies(): LiveData<List<ItemEntitySameWithResponse>> = movieCatalogueRepository.getAllMovies()
}