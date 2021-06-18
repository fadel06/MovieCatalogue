package com.belajar.moviecatalogue.ui.movieandtvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.belajar.moviecatalogue.data.source.local.entity.MovieEntity
import com.belajar.moviecatalogue.data.source.MovieCatalogueRepository
import com.belajar.moviecatalogue.data.source.local.entity.TvShowEntity
import com.belajar.moviecatalogue.utils.Data
import com.belajar.moviecatalogue.vo.Resource
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
    companion object {
        private const val MOVIE = "movie"
        private const val TV_SHOW = "tv_show"
    }

    private lateinit var viewModel: MovieAndTvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var movieObserver: Observer<Resource<List<MovieEntity>>>

    @Mock
    private lateinit var tvShowObserver: Observer<Resource<List<TvShowEntity>>>

    @Before
    fun setUp(){
        viewModel = MovieAndTvShowViewModel(movieCatalogueRepository)
    }

    @Test
    fun getMovies(){
        val dummyMovies = Resource.success(Data.generateMovies())
        val listMovies = MutableLiveData<Resource<List<MovieEntity>>>()
        listMovies.value = dummyMovies

        Mockito.`when`(movieCatalogueRepository.getAllMovies()).thenReturn(listMovies)
        viewModel.setItems(MOVIE)
        val movies = viewModel.getMovies().value?.data
        Mockito.verify(movieCatalogueRepository).getAllMovies()
        assertNotNull(movies)
        assertEquals(16, movies?.size)

        viewModel.getMovies().observeForever(movieObserver)
        Mockito.verify(movieObserver).onChanged(dummyMovies)
    }

    @Test
    fun getTvShows(){
        val dummyTvShows = Resource.success(Data.generateTvShows())
        val listTvShows = MutableLiveData<Resource<List<TvShowEntity>>>()
        listTvShows.value = dummyTvShows

        Mockito.`when`(movieCatalogueRepository.getAllTvShows()).thenReturn(listTvShows)
        viewModel.setItems(TV_SHOW)
        val tvShows = viewModel.getTvShows().value?.data
        Mockito.verify(movieCatalogueRepository).getAllTvShows()
        assertNotNull(tvShows)
        assertEquals(15, tvShows?.size)

        viewModel.getTvShows().observeForever(tvShowObserver)
        Mockito.verify(tvShowObserver).onChanged(dummyTvShows)
    }
}