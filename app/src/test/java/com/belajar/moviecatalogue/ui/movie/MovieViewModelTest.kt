package com.belajar.moviecatalogue.ui.movie

import com.belajar.moviecatalogue.data.ItemEntity
import com.belajar.moviecatalogue.data.source.MovieCatalogueRepository
import com.belajar.moviecatalogue.utils.Data
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest{
    private lateinit var viewModel: MovieViewModel

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Before
    fun setUp(){
        viewModel = MovieViewModel(movieCatalogueRepository)
    }

    @Test
    fun getMovies(){
        `when`(movieCatalogueRepository.getAllMovies()).thenReturn(
            Data.generateMovies() as ArrayList<ItemEntity>
        )
        val movies = viewModel.getMovies()
        verify(movieCatalogueRepository).getAllMovies()
        assertNotNull(movies)
        assertEquals(16, movies.size)
    }
}
