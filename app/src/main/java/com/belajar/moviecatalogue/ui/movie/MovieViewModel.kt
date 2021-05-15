package com.belajar.moviecatalogue.ui.movie

import androidx.lifecycle.ViewModel
import com.belajar.moviecatalogue.utils.Data
import com.belajar.moviecatalogue.data.MovieEntity

class MovieViewModel : ViewModel() {
    fun getMovies(): List<MovieEntity> = Data.generateMovies()
}