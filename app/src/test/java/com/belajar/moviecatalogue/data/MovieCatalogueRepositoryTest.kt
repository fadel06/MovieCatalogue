package com.belajar.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.belajar.moviecatalogue.FakeDataRemote
import com.belajar.moviecatalogue.data.source.remote.RemoteDataSource
import com.belajar.moviecatalogue.utils.LiveDataTestUtils
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.verify

class MovieCatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val movieCatalogueRepository = FakeMovieCatalogueRepository(remote)

    private val id = 1
    private val dummyMovies = FakeDataRemote.generateRemoteDummyMovies()
    private val dummyMovie = FakeDataRemote.movieDetail(id)
    private val dummyTvShows = FakeDataRemote.generateRemoteDummyTvShows()
    private val dummyTvShow = FakeDataRemote.tvShowDetail(id)

    @Test
    fun getAllMovies(){
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(dummyMovies)
            null
        }.`when`(remote).getAllMovies(any())
        val movieEntities = LiveDataTestUtils.getValue(movieCatalogueRepository.getAllMovies())
        verify(remote).getAllMovies(any())
        assertNotNull(movieEntities)
        assertEquals(dummyMovies.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getAllTvShows(){
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowsCallback)
                .onAllTvShowsReceived(dummyTvShows)
            null
        }.`when`(remote).getAllTvShows(any())
        val tvShowEntities = LiveDataTestUtils.getValue(movieCatalogueRepository.getAllTvShows())
        verify(remote).getAllTvShows(any())
        assertNotNull(tvShowEntities)
        assertEquals(dummyTvShows.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun getMovie(){
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailMovieCallback)
                .onDetailMovieReceived(dummyMovie)
            null
        }.`when`(remote).getDetailMovie(eq(id), any())
        val resultMovie = LiveDataTestUtils.getValue(movieCatalogueRepository.getDetailMovie(id))
        verify(remote).getDetailMovie(eq(id), any())
        assertNotNull(resultMovie)
        assertEquals(dummyMovie?.id, resultMovie?.id)
        assertEquals(dummyMovie?.title, resultMovie?.title)
        assertEquals(dummyMovie?.description, resultMovie?.description)
        assertEquals(dummyMovie?.poster, resultMovie?.poster)
        assertEquals(dummyMovie?.release, resultMovie?.release)
        assertEquals(dummyMovie?.rating, resultMovie?.rating)
        assertEquals(dummyMovie?.trailer, resultMovie?.trailer)
        assertEquals(dummyMovie?.crews?.size, resultMovie?.crews?.size)
    }

    @Test
    fun getTvShow(){
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailTvShowCallback)
                .onDetailTvShowReceived(dummyTvShow)
            null
        }.`when`(remote).getDetailTvShow(eq(id), any())
        val resultTvShow = LiveDataTestUtils.getValue(movieCatalogueRepository.getDetailTvShow(id))
        verify(remote).getDetailTvShow(eq(id), any())
        assertNotNull(resultTvShow)
        assertEquals(dummyTvShow?.id, resultTvShow?.id)
        assertEquals(dummyTvShow?.title, resultTvShow?.title)
        assertEquals(dummyTvShow?.description, resultTvShow?.description)
        assertEquals(dummyTvShow?.poster, resultTvShow?.poster)
        assertEquals(dummyTvShow?.release, resultTvShow?.release)
        assertEquals(dummyTvShow?.rating, resultTvShow?.rating)
        assertEquals(dummyTvShow?.trailer, resultTvShow?.trailer)
        assertEquals(dummyTvShow?.crews?.size, resultTvShow?.crews?.size)
    }

    private fun delayTwoSecond() {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}