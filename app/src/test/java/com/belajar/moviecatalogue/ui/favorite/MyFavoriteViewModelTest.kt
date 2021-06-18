package com.belajar.moviecatalogue.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.belajar.moviecatalogue.utils.FakeDataRemote
import com.belajar.moviecatalogue.data.source.MovieCatalogueRepository
import com.belajar.moviecatalogue.data.source.local.entity.MovieEntity
import com.belajar.moviecatalogue.data.source.local.entity.TvShowEntity
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MyFavoriteViewModelTest{
    companion object {
        private const val MOVIE = "movie"
        private const val TV_SHOW = "tv_show"
    }

    private lateinit var viewModel: MyFavoriteViewModel

    private val id = 1
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var movieObserver: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var tvShowObserver: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var pagedListMovie: PagedList<MovieEntity>

    @Mock
    private lateinit var pagedListTvShow: PagedList<TvShowEntity>

    @Before
    fun setUp(){
        viewModel = MyFavoriteViewModel(movieCatalogueRepository)
    }

    @Test
    fun getFavoriteMovies(){
        val dummyFavoriteMovie = pagedListMovie
        `when`(dummyFavoriteMovie.size).thenReturn(3)
        val favoriteMovies = MutableLiveData<PagedList<MovieEntity>>()
        favoriteMovies.value = dummyFavoriteMovie

        `when`(movieCatalogueRepository.getFavoriteMovies()).thenReturn(favoriteMovies)
        viewModel.setFavoriteItems(MOVIE)
        val movie = viewModel.getFavoriteMovies().value
        verify(movieCatalogueRepository).getFavoriteMovies()
        assertNotNull(movie)
        assertEquals(3, movie?.size)

        viewModel.getFavoriteMovies().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyFavoriteMovie)
    }

    @Test
    fun setFavoriteMovie() {
        viewModel.setFavoriteMovie(FakeDataRemote.movieDetail(id))
        verify(movieCatalogueRepository).setFavoriteMovie(FakeDataRemote.movieDetail(id), true)
        verifyNoMoreInteractions(movieCatalogueRepository)
    }

    @Test
    fun getFavoriteTvShows(){
        val dummyFavoriteTvShow = pagedListTvShow
        `when`(dummyFavoriteTvShow.size).thenReturn(3)
        val favoriteTvShows = MutableLiveData<PagedList<TvShowEntity>>()
        favoriteTvShows.value = dummyFavoriteTvShow

        `when`(movieCatalogueRepository.getFavoriteTvShows()).thenReturn(favoriteTvShows)
        viewModel.setFavoriteItems(TV_SHOW)
        val tvShow = viewModel.getFavoriteTvShows().value
        verify(movieCatalogueRepository).getFavoriteTvShows()
        assertNotNull(tvShow)
        assertEquals(3, tvShow?.size)

        viewModel.getFavoriteTvShows().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyFavoriteTvShow)
    }

    @Test
    fun setFavoriteTvShow() {
        viewModel.setFavoriteTvShow(FakeDataRemote.tvShowDetail(id))
        verify(movieCatalogueRepository).setFavoriteTvShow(FakeDataRemote.tvShowDetail(id), true)
        verifyNoMoreInteractions(movieCatalogueRepository)
    }

}