package com.belajar.moviecatalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import com.belajar.moviecatalogue.data.ItemEntity
import com.belajar.moviecatalogue.utils.Data
import com.belajar.moviecatalogue.data.source.MovieCatalogueRepository

class TvShowViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) :
    ViewModel() {
    //    fun getTvShows() : List<TvShowEntity> = Data.generateTvShows()
    fun getTvShows(): List<ItemEntity> = movieCatalogueRepository.getAllTvShows()
}