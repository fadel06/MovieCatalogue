package com.belajar.moviecatalogue.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.belajar.moviecatalogue.data.ItemEntitySameWithResponse
import com.belajar.moviecatalogue.data.source.MovieCatalogueRepository
import com.belajar.moviecatalogue.utils.Data
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest{
    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var observer: Observer<List<ItemEntitySameWithResponse>>


    @Before
    fun setUp(){
        viewModel = TvShowViewModel(movieCatalogueRepository)
    }

    @Test
    fun getTvShows(){
        val dummyTvShows = Data.generateTvShows()
        val listTvShows = MutableLiveData<List<ItemEntitySameWithResponse>>()
        listTvShows.value = dummyTvShows
        `when`(movieCatalogueRepository.getAllTvShows()).thenReturn(listTvShows)
        val tvShows = viewModel.getTvShows().value
        verify(movieCatalogueRepository).getAllTvShows()
        assertNotNull(tvShows)
        assertEquals(15, tvShows?.size)

        viewModel.getTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShows)
    }
}