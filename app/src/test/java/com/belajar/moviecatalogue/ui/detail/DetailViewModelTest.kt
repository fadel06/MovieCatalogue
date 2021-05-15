package com.belajar.moviecatalogue.ui.detail

import com.belajar.moviecatalogue.utils.Data
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class DetailViewModelTest{
    private val id = 1
    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = Data.movieDetail(id)
    private val dummyTvShow = Data.tvShowDetail(id)
    private val dummyMovieCrew = dummyMovie?.crews?.get(id)
    private val dummyTvShowCrew = dummyTvShow?.crews?.get(id)

    @Before
    fun setUp(){
        viewModel = DetailViewModel()
    }

    @Test
    fun getMovie(){
        val movie = viewModel.getMovieDetail(id)
        assertNotNull(movie)
        assertEquals(dummyMovie?.movieId, movie?.movieId)
        assertEquals(dummyMovie?.movieTitle, movie?.movieTitle)
        assertEquals(dummyMovie?.moviePoster, movie?.moviePoster)
        assertEquals(dummyMovie?.movieRelease, movie?.movieRelease)
        assertEquals(dummyMovie?.movieRating, movie?.movieRating)
        assertEquals(dummyMovie?.movieDescription, movie?.movieDescription)
        assertEquals(dummyMovie?.movieTrailer, movie?.movieTrailer)
    }

    @Test
    fun getMovieCrews(){
        val movie = viewModel.getMovieDetail(id)
        val crews = viewModel.getMovieCrews(movie)
        assertNotNull(crews)
        assertEquals(5, crews?.size)
    }

    @Test
    fun getMovieCrewDetail(){
        val movie = viewModel.getMovieDetail(id)
        val crews = viewModel.getMovieCrews(movie)
        val crew = crews?.get(id)
        assertNotNull(crew)
        assertEquals(dummyMovieCrew?.crewName, crew?.crewName)
        assertEquals(dummyMovieCrew?.crewPosition, crew?.crewPosition)
        assertEquals(dummyMovieCrew?.crewPhoto, crew?.crewPhoto)
    }

    @Test
    fun getTvShow(){
        val tvShow = viewModel.getTvShowDetail(id)
        assertNotNull(tvShow)
        assertEquals(dummyTvShow?.tvShowId, tvShow?.tvShowId)
        assertEquals(dummyTvShow?.tvShowTitle, tvShow?.tvShowTitle)
        assertEquals(dummyTvShow?.tvShowPoster, tvShow?.tvShowPoster)
        assertEquals(dummyTvShow?.tvShowRelease, tvShow?.tvShowRelease)
        assertEquals(dummyTvShow?.tvShowRating, tvShow?.tvShowRating)
        assertEquals(dummyTvShow?.tvShowDescription, tvShow?.tvShowDescription)
        assertEquals(dummyTvShow?.tvShowTrailer, tvShow?.tvShowTrailer)
    }

    @Test
    fun getTvShowCrews(){
        val tvShow = viewModel.getTvShowDetail(id)
        val crews = viewModel.getTvShowCrews(tvShow)
        assertNotNull(crews)
        assertEquals(3, crews?.size)
    }

    @Test
    fun getTvShowCrewDetail(){
        val tvShow = viewModel.getTvShowDetail(id)
        val crews = viewModel.getTvShowCrews(tvShow)
        val crew = crews?.get(id)
        assertNotNull(crew)
        assertEquals(dummyTvShowCrew?.crewName, crew?.crewName)
        assertEquals(dummyTvShowCrew?.crewPosition, crew?.crewPosition)
        assertEquals(dummyTvShowCrew?.crewPhoto, crew?.crewPhoto)
    }
}