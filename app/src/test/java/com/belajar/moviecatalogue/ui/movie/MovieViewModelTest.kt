package com.belajar.moviecatalogue.ui.movie

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MovieViewModelTest{
    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp(){
        viewModel = MovieViewModel()
    }

    @Test
    fun getMovies(){
        val movies = viewModel.getMovies()
        assertNotNull(movies)
        assertEquals(16, movies.size)
    }
}
