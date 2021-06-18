package com.belajar.moviecatalogue.ui.detail

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
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest{

    companion object {
        private const val MOVIE = "movie"
        private const val TV_SHOW = "tv_show"
    }
    private val id = 1
    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = Resource.success(Data.movieDetail(id))
    private val dummyTvShow = Resource.success(Data.tvShowDetail(id))
    private val dummyMovieCrew = dummyMovie.data?.crewEntity?.get(id)
    private val dummyTvShowCrew = dummyTvShow.data?.crewEntity?.get(id)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var movieObserver: Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var tvShowObserver: Observer<Resource<TvShowEntity>>


    @Before
    fun setUp(){
        viewModel = DetailViewModel(movieCatalogueRepository)
    }

    @Test
    fun getMovie(){
        val movieResult = MutableLiveData<Resource<MovieEntity>>()
        movieResult.value = dummyMovie
        `when`(movieCatalogueRepository.getDetailMovie(id)).thenReturn(movieResult)
        viewModel.setItem(id, MOVIE)
        val movie = viewModel.getMovie().value?.data
        verify(movieCatalogueRepository).getDetailMovie(id)
        assertNotNull(movie)
        assertEquals(dummyMovie.data?.id, movie?.id)
        assertEquals(dummyMovie.data?.title, movie?.title)
        assertEquals(dummyMovie.data?.poster, movie?.poster)
        assertEquals(dummyMovie.data?.release, movie?.release)
        assertEquals(dummyMovie.data?.rating, movie?.rating)
        assertEquals(dummyMovie.data?.description, movie?.description)
        assertEquals(dummyMovie.data?.trailer, movie?.trailer)

        viewModel.getMovie().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)

    }

    @Test
    fun getMovieCrews(){
        val movieResult = MutableLiveData<Resource<MovieEntity>>()
        movieResult.value = dummyMovie
        `when`(movieCatalogueRepository.getDetailMovie(id)).thenReturn(movieResult)
        viewModel.setItem(id, MOVIE)
        val movie = viewModel.getMovie().value?.data
        verify(movieCatalogueRepository).getDetailMovie(id)
        val crews = viewModel.getMovieCrews(movie)
        assertNotNull(crews)
        assertEquals(5, crews?.size)
    }

    @Test
    fun getMovieCrewDetail(){
        val movieResult = MutableLiveData<Resource<MovieEntity>>()
        movieResult.value = dummyMovie
        `when`(movieCatalogueRepository.getDetailMovie(id)).thenReturn(movieResult)
        viewModel.setItem(id, MOVIE)
        val movie = viewModel.getMovie().value?.data
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
        val tvShowResult = MutableLiveData<Resource<TvShowEntity>>()
        tvShowResult.value = dummyTvShow
        `when`(movieCatalogueRepository.getDetailTvShow(id)).thenReturn(tvShowResult)
        viewModel.setItem(id, TV_SHOW)
        val tvShow = viewModel.getTvShow().value?.data
        verify(movieCatalogueRepository).getDetailTvShow(id)
        assertNotNull(tvShow)
        assertEquals(dummyTvShow.data?.id, tvShow?.id)
        assertEquals(dummyTvShow.data?.title, tvShow?.title)
        assertEquals(dummyTvShow.data?.poster, tvShow?.poster)
        assertEquals(dummyTvShow.data?.release, tvShow?.release)
        assertEquals(dummyTvShow.data?.rating, tvShow?.rating)
        assertEquals(dummyTvShow.data?.description, tvShow?.description)
        assertEquals(dummyTvShow.data?.trailer, tvShow?.trailer)

        viewModel.getTvShow().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShow)
    }

    @Test
    fun getTvShowCrews(){
        val tvShowResult = MutableLiveData<Resource<TvShowEntity>>()
        tvShowResult.value = dummyTvShow
        `when`(movieCatalogueRepository.getDetailTvShow(id)).thenReturn(tvShowResult)
        viewModel.setItem(id, TV_SHOW)
        val tvShow = viewModel.getTvShow().value?.data
        verify(movieCatalogueRepository).getDetailTvShow(id)
        val crews = viewModel.getTvShowCrews(tvShow)
        assertNotNull(crews)
        assertEquals(3, crews?.size)
    }

    @Test
    fun getTvShowCrewDetail(){
        val tvShowResult = MutableLiveData<Resource<TvShowEntity>>()
        tvShowResult.value = dummyTvShow
        `when`(movieCatalogueRepository.getDetailTvShow(id)).thenReturn(tvShowResult)
        viewModel.setItem(id, TV_SHOW)
        val tvShow = viewModel.getTvShow().value?.data
        verify(movieCatalogueRepository).getDetailTvShow(id)
        val crews = viewModel.getTvShowCrews(tvShow)
        val crew = crews?.get(id)
        assertNotNull(crew)
        assertEquals(dummyTvShowCrew?.crewName, crew?.crewName)
        assertEquals(dummyTvShowCrew?.crewPosition, crew?.crewPosition)
        assertEquals(dummyTvShowCrew?.crewPhoto, crew?.crewPhoto)
    }
}