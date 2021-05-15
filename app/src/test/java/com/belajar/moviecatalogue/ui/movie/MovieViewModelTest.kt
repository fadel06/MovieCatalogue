package com.belajar.moviecatalogue.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.belajar.moviecatalogue.data.ItemEntitySameWithResponse
import com.belajar.moviecatalogue.data.source.MovieCatalogueRepository
import com.belajar.moviecatalogue.utils.Data
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest{
    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var observer: Observer<List<ItemEntitySameWithResponse>>

    @Before
    fun setUp(){
        viewModel = MovieViewModel(movieCatalogueRepository)
    }

    @Test
    fun getMovies(){
        val dummyMovies = Data.generateMovies()
        val listMovies = MutableLiveData<List<ItemEntitySameWithResponse>>()
        listMovies.value = dummyMovies

        `when`(movieCatalogueRepository.getAllMovies()).thenReturn(listMovies)
        val movies = viewModel.getMovies().value
        verify(movieCatalogueRepository).getAllMovies()
        assertNotNull(movies)
        assertEquals(16, movies?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}
