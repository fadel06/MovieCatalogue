package com.belajar.moviecatalogue.ui.tvshow

import com.belajar.moviecatalogue.data.ItemEntity
import com.belajar.moviecatalogue.data.source.MovieCatalogueRepository
import com.belajar.moviecatalogue.utils.Data
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest{
    private lateinit var viewModel: TvShowViewModel

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Before
    fun setUp(){
        viewModel = TvShowViewModel(movieCatalogueRepository)
    }

    @Test
    fun getTvShows(){
        `when`(movieCatalogueRepository.getAllTvShows()).thenReturn(
            Data.generateTvShows() as ArrayList<ItemEntity>
        )
        val tvShows = viewModel.getTvShows()
        verify(movieCatalogueRepository).getAllTvShows()
        assertNotNull(tvShows)
        assertEquals(15, tvShows.size)
    }
}