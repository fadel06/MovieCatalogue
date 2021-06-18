package com.belajar.moviecatalogue.ui.movieandtvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
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
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
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
    private lateinit var movieObserver: Observer<Resource<PagedList<MovieEntity>>>

    @Mock
    private lateinit var tvShowObserver: Observer<Resource<PagedList<TvShowEntity>>>

    @Mock
    private lateinit var pagedListMovie: PagedList<MovieEntity>

    @Mock
    private lateinit var pagedListTvShow: PagedList<TvShowEntity>

    @Before
    fun setUp(){
        viewModel = MovieAndTvShowViewModel(movieCatalogueRepository)
    }

    @Test
    fun getMovies(){
        val dummyMovies = Resource.success(pagedListMovie)
        `when`(dummyMovies.data?.size).thenReturn(16)
        val listMovies = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        listMovies.value = dummyMovies

        `when`(movieCatalogueRepository.getAllMovies()).thenReturn(listMovies)
        viewModel.setItems(MOVIE)
        val movies = viewModel.getMovies().value?.data
        verify(movieCatalogueRepository).getAllMovies()
        assertNotNull(movies)
        assertEquals(16, movies?.size)

        viewModel.getMovies().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovies)
    }

    @Test
    fun getTvShows(){
        val dummyTvShows = Resource.success(pagedListTvShow)
        `when`(dummyTvShows.data?.size).thenReturn(15)
        val listTvShows = MutableLiveData<Resource<PagedList<TvShowEntity>>>()
        listTvShows.value = dummyTvShows

        `when`(movieCatalogueRepository.getAllTvShows()).thenReturn(listTvShows)
        viewModel.setItems(TV_SHOW)
        val tvShows = viewModel.getTvShows().value?.data
        verify(movieCatalogueRepository).getAllTvShows()
        assertNotNull(tvShows)
        assertEquals(15, tvShows?.size)

        viewModel.getTvShows().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShows)
    }
}