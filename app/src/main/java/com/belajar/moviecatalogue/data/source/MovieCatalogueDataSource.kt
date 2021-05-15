package com.belajar.moviecatalogue.data.source

import com.belajar.moviecatalogue.data.ItemEntity

interface MovieCatalogueDataSource {

    fun getAllMovies(): List<ItemEntity>

    fun getAllTvShows(): List<ItemEntity>

    fun getDetailMovie(id: Int) : ItemEntity?

    fun getDetailTvShow(id: Int) : ItemEntity?
}