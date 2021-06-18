package com.belajar.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.belajar.moviecatalogue.FakeDataRemote
import com.belajar.moviecatalogue.data.source.local.LocalDataSource
import com.belajar.moviecatalogue.data.source.local.entity.MovieEntity
import com.belajar.moviecatalogue.data.source.local.entity.TvShowEntity
import com.belajar.moviecatalogue.data.source.remote.RemoteDataSource
import com.belajar.moviecatalogue.utils.AppExecutors
import com.belajar.moviecatalogue.utils.LiveDataTestUtils
import com.nhaarman.mockitokotlin2.eq
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

class MovieCatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val local = Mockito.mock(LocalDataSource::class.java)
    private val appExecutors = Mockito.mock(AppExecutors::class.java)
    private val movieCatalogueRepository = FakeMovieCatalogueRepository(remote, local, appExecutors)

    private val id = 1
    private val dummyMovies = MutableLiveData<List<MovieEntity>>()
    private val dummyMovie = MutableLiveData<MovieEntity>()
    private val dummyTvShows = MutableLiveData<List<TvShowEntity>>()
    private val dummyTvShow = MutableLiveData<TvShowEntity>()

    @Test
    fun getAllMovies(){
        dummyMovies.value = FakeDataRemote.generateRemoteDummyMovies()
        `when`(local.getAllMovies()).thenReturn(dummyMovies)
        val movieEntities = LiveDataTestUtils.getValue(movieCatalogueRepository.getAllMovies())
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(dummyMovies.value?.size?.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvShows(){
        dummyTvShows.value = FakeDataRemote.generateRemoteDummyTvShows()
        `when`(local.getAllTvShows()).thenReturn(dummyTvShows)
        val tvShowEntities = LiveDataTestUtils.getValue(movieCatalogueRepository.getAllTvShows())
        verify(local).getAllTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(dummyTvShows.value?.size?.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getMovie(){
        dummyMovie.value = FakeDataRemote.movieDetail(id)
        `when`(local.getMovieById(id)).thenReturn(dummyMovie)
        val resultMovie = LiveDataTestUtils.getValue(movieCatalogueRepository.getDetailMovie(id))
        verify(local).getMovieById(eq(id))
        assertNotNull(resultMovie)
        assertEquals(dummyMovie.value?.id, resultMovie.data?.id)
        assertEquals(dummyMovie.value?.title, resultMovie.data?.title)
        assertEquals(dummyMovie.value?.description, resultMovie.data?.description)
        assertEquals(dummyMovie.value?.poster, resultMovie.data?.poster)
        assertEquals(dummyMovie.value?.release, resultMovie.data?.release)
        assertEquals(dummyMovie.value?.rating, resultMovie.data?.rating)
        assertEquals(dummyMovie.value?.trailer, resultMovie.data?.trailer)
        assertEquals(dummyMovie.value?.crewEntity?.size, resultMovie.data?.crewEntity?.size)
    }

    @Test
    fun getTvShow(){
        dummyTvShow.value = FakeDataRemote.tvShowDetail(id)
        `when`(local.getTvShowById(id)).thenReturn(dummyTvShow)
        val resultTvShow = LiveDataTestUtils.getValue(movieCatalogueRepository.getDetailTvShow(id))
        verify(local).getTvShowById(eq(id))
        assertNotNull(resultTvShow)
        assertEquals(dummyTvShow.value?.id, resultTvShow.data?.id)
        assertEquals(dummyTvShow.value?.title, resultTvShow.data?.title)
        assertEquals(dummyTvShow.value?.description, resultTvShow.data?.description)
        assertEquals(dummyTvShow.value?.poster, resultTvShow.data?.poster)
        assertEquals(dummyTvShow.value?.release, resultTvShow.data?.release)
        assertEquals(dummyTvShow.value?.rating, resultTvShow.data?.rating)
        assertEquals(dummyTvShow.value?.trailer, resultTvShow.data?.trailer)
        assertEquals(dummyTvShow.value?.crewEntity?.size, resultTvShow.data?.crewEntity?.size)
    }

    @Test
    fun getFavoriteMovies(){
        dummyMovies.value = FakeDataRemote.generateRemoteDummyMovies()
        `when`(local.getFavMovie()).thenReturn(dummyMovies)

        val movieEntities = LiveDataTestUtils.getValue(movieCatalogueRepository.getFavoriteMovies())
        verify(local).getFavMovie()
        assertNotNull(movieEntities)
        assertEquals(dummyMovies.value?.size?.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getFavoriteTvShows(){
        dummyTvShows.value = FakeDataRemote.generateRemoteDummyTvShows()
        `when`(local.getFavTvShow()).thenReturn(dummyTvShows)

        val tvShowEntities = LiveDataTestUtils.getValue(movieCatalogueRepository.getFavoriteTvShows())
        verify(local).getFavTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(dummyTvShows.value?.size?.toLong(), tvShowEntities.size.toLong())
    }
}