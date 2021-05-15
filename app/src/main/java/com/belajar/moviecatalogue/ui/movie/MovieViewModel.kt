package com.belajar.moviecatalogue.ui.movie

import androidx.lifecycle.ViewModel
import com.belajar.moviecatalogue.data.ItemEntity
import com.belajar.moviecatalogue.data.source.MovieCatalogueRepository

class MovieViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {
//    fun getMovies(): List<MovieEntity> = Data.generateMovies()
    fun getMovies(): List<ItemEntity> = movieCatalogueRepository.getAllMovies()
}