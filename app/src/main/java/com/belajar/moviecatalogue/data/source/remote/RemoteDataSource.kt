package com.belajar.moviecatalogue.data.source.remote

import com.belajar.moviecatalogue.data.ItemEntity
import com.belajar.moviecatalogue.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper){

    companion object{
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper) : RemoteDataSource =
            instance ?: synchronized(this){
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getAllMovies(): List<ItemEntity> = jsonHelper.loadMovies()

    fun getAllTvShows(): List<ItemEntity> = jsonHelper.loadTvShows()

    fun getDetailMovie(id : Int) : ItemEntity? = jsonHelper.loadMovieDetail(id)

    fun getDetailTvShow(id : Int) : ItemEntity? = jsonHelper.loadTvShowDetail(id)
}