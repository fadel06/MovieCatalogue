package com.belajar.moviecatalogue.ui.movieandtvshow

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
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieAndTvShowViewModelTest{
    private lateinit var viewModel: MovieAndTvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var observer: Observer<List<ItemEntitySameWithResponse>>

    @Before
    fun setUp(){
        viewModel = MovieAndTvShowViewModel(movieCatalogueRepository)
    }

    @Test
    fun getMovies(){
        val dummyMovies = Data.generateMovies()
        val listMovies = MutableLiveData<List<ItemEntitySameWithResponse>>()
        listMovies.value = dummyMovies

        Mockito.`when`(movieCatalogueRepository.getAllMovies()).thenReturn(listMovies)
        val movies = viewModel.getMovies().value
        Mockito.verify(movieCatalogueRepository).getAllMovies()
        assertNotNull(movies)
        assertEquals(16, movies?.size)

        viewModel.getMovies().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyMovies)
    }

    @Test
    fun getTvShows(){
        val dummyTvShows = Data.generateTvShows()
        val listTvShows = MutableLiveData<List<ItemEntitySameWithResponse>>()
        listTvShows.value = dummyTvShows

        Mockito.`when`(movieCatalogueRepository.getAllTvShows()).thenReturn(listTvShows)
        val tvShows = viewModel.getTvShows().value
        Mockito.verify(movieCatalogueRepository).getAllTvShows()
        assertNotNull(tvShows)
        assertEquals(15, tvShows?.size)

        viewModel.getTvShows().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTvShows)
    }
}