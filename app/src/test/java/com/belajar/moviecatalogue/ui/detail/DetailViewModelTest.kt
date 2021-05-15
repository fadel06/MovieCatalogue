package com.belajar.moviecatalogue.ui.detail

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
class DetailViewModelTest{
    private val id = 1
    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = Data.movieDetail(id)
    private val dummyTvShow = Data.tvShowDetail(id)
    private val dummyMovieCrew = dummyMovie?.crews?.get(id)
    private val dummyTvShowCrew = dummyTvShow?.crews?.get(id)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var observer: Observer<ItemEntitySameWithResponse?>


    @Before
    fun setUp(){
        viewModel = DetailViewModel(movieCatalogueRepository)
    }

    @Test
    fun getMovie(){
        val movieResult = MutableLiveData<ItemEntitySameWithResponse>()
        movieResult.value = dummyMovie
        `when`(movieCatalogueRepository.getDetailMovie(id)).thenReturn(movieResult)
        val movie = viewModel.getMovieDetail(id).value
        verify(movieCatalogueRepository).getDetailMovie(id)
        assertNotNull(movie)
        assertEquals(dummyMovie?.id, movie?.id)
        assertEquals(dummyMovie?.title, movie?.title)
        assertEquals(dummyMovie?.poster, movie?.poster)
        assertEquals(dummyMovie?.release, movie?.release)
        assertEquals(dummyMovie?.rating, movie?.rating)
        assertEquals(dummyMovie?.description, movie?.description)
        assertEquals(dummyMovie?.trailer, movie?.trailer)

        viewModel.getMovieDetail(id).observeForever(observer)
        verify(observer).onChanged(dummyMovie)

    }

    @Test
    fun getMovieCrews(){
        val movieResult = MutableLiveData<ItemEntitySameWithResponse?>()
        movieResult.value = dummyMovie
        `when`(movieCatalogueRepository.getDetailMovie(id)).thenReturn(movieResult)
        val movie = viewModel.getMovieDetail(id).value
        verify(movieCatalogueRepository).getDetailMovie(id)
        val crews = viewModel.getMovieCrews(movie)
        assertNotNull(crews)
        assertEquals(5, crews?.size)
    }

    @Test
    fun getMovieCrewDetail(){
        val movieResult = MutableLiveData<ItemEntitySameWithResponse?>()
        movieResult.value = dummyMovie
        `when`(movieCatalogueRepository.getDetailMovie(id)).thenReturn(movieResult)
        val movie = viewModel.getMovieDetail(id).value
        verify(movieCatalogueRepository).getDetailMovie(id)
        val crews = viewModel.getMovieCrews(movie)
        val crew = crews?.get(id)
        assertNotNull(crew)
        assertEquals(dummyMovieCrew?.crewName, crew?.crewName)
        assertEquals(dummyMovieCrew?.crewPosition, crew?.crewPosition)
        assertEquals(dummyMovieCrew?.crewPhoto, crew?.crewPhoto)
    }

    @Test
    fun getTvShow(){
        val tvShowResult = MutableLiveData<ItemEntitySameWithResponse>()
        tvShowResult.value = dummyTvShow
        `when`(movieCatalogueRepository.getDetailTvShow(id)).thenReturn(tvShowResult)
        val tvShow = viewModel.getTvShowDetail(id).value
        verify(movieCatalogueRepository).getDetailTvShow(id)
        assertNotNull(tvShow)
        assertEquals(dummyTvShow?.id, tvShow?.id)
        assertEquals(dummyTvShow?.title, tvShow?.title)
        assertEquals(dummyTvShow?.poster, tvShow?.poster)
        assertEquals(dummyTvShow?.release, tvShow?.release)
        assertEquals(dummyTvShow?.rating, tvShow?.rating)
        assertEquals(dummyTvShow?.description, tvShow?.description)
        assertEquals(dummyTvShow?.trailer, tvShow?.trailer)

        viewModel.getTvShowDetail(id).observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }

    @Test
    fun getTvShowCrews(){
        val tvShowResult = MutableLiveData<ItemEntitySameWithResponse>()
        tvShowResult.value = dummyTvShow
        `when`(movieCatalogueRepository.getDetailTvShow(id)).thenReturn(tvShowResult)
        val tvShow = viewModel.getTvShowDetail(id).value
        verify(movieCatalogueRepository).getDetailTvShow(id)
        val crews = viewModel.getTvShowCrews(tvShow)
        assertNotNull(crews)
        assertEquals(3, crews?.size)
    }

    @Test
    fun getTvShowCrewDetail(){
        val tvShowResult = MutableLiveData<ItemEntitySameWithResponse>()
        tvShowResult.value = dummyTvShow
        `when`(movieCatalogueRepository.getDetailTvShow(id)).thenReturn(tvShowResult)
        val tvShow = viewModel.getTvShowDetail(id).value
        verify(movieCatalogueRepository).getDetailTvShow(id)
        val crews = viewModel.getTvShowCrews(tvShow)
        val crew = crews?.get(id)
        assertNotNull(crew)
        assertEquals(dummyTvShowCrew?.crewName, crew?.crewName)
        assertEquals(dummyTvShowCrew?.crewPosition, crew?.crewPosition)
        assertEquals(dummyTvShowCrew?.crewPhoto, crew?.crewPhoto)
    }
}