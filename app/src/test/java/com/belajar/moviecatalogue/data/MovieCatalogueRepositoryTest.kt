package com.belajar.moviecatalogue.data

import com.belajar.moviecatalogue.FakeDataRemote
import com.belajar.moviecatalogue.data.source.remote.RemoteDataSource
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

class MovieCatalogueRepositoryTest {
    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val movieCatalogueRepository = FakeMovieCatalogueRepository(remote)

    private val id = 1
    private val dummyMovies = FakeDataRemote.generateRemoteDummyMovies()
    private val dummyMovie = FakeDataRemote.movieDetail(id)
    private val dummyTvShows = FakeDataRemote.generateRemoteDummyTvShows()
    private val dummyTvShow = FakeDataRemote.tvShowDetail(id)

    @Test
    fun getAllMovies(){
        `when`(remote.getAllMovies()).thenReturn(dummyMovies)
        val movieEntities = movieCatalogueRepository.getAllMovies()
        verify(remote).getAllMovies()
        assertNotNull(movieEntities)
        assertEquals(dummyMovies.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getAllTvShows(){
        `when`(remote.getAllTvShows()).thenReturn(dummyTvShows)
        val tvShowEntities = movieCatalogueRepository.getAllTvShows()
        verify(remote).getAllTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(dummyTvShows.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun getMovie(){
        `when`(remote.getDetailMovie(id)).thenReturn(dummyMovie)
        val resultMovie = movieCatalogueRepository.getDetailMovie(id)
        verify(remote).getDetailMovie(id)
        assertNotNull(resultMovie)
        assertEquals(dummyMovie?.poster, resultMovie?.poster)
    }

    @Test
    fun getTvShow(){
        `when`(remote.getDetailTvShow(id)).thenReturn(dummyTvShow)
        val resultTvShow = movieCatalogueRepository.getDetailTvShow(id)
        verify(remote).getDetailTvShow(id)
        assertNotNull(resultTvShow)
        assertEquals(dummyTvShow?.poster, resultTvShow?.poster)
    }
}