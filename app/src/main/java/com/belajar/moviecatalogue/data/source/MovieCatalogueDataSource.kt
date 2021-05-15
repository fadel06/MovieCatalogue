package com.belajar.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.belajar.moviecatalogue.data.ItemEntitySameWithResponse

interface MovieCatalogueDataSource {

    fun getAllMovies(): LiveData<List<ItemEntitySameWithResponse>>

    fun getAllTvShows(): LiveData<List<ItemEntitySameWithResponse>>

    fun getDetailMovie(id: Int) : LiveData<ItemEntitySameWithResponse?>

    fun getDetailTvShow(id: Int) : LiveData<ItemEntitySameWithResponse?>
}