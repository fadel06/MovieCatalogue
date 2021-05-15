package com.belajar.moviecatalogue.data.source.remote

import android.os.Handler
import android.os.Looper
import com.belajar.moviecatalogue.data.ItemEntitySameWithResponse
import com.belajar.moviecatalogue.utils.EspressoIdlingResource
import com.belajar.moviecatalogue.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper){

    private val handler = Handler(Looper.getMainLooper())

    companion object{
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper) : RemoteDataSource =
            instance ?: synchronized(this){
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getAllMovies(callback : LoadMoviesCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllMoviesReceived(jsonHelper.loadMovies())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getAllTvShows(callback: LoadTvShowsCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllTvShowsReceived(jsonHelper.loadTvShows())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getDetailMovie(id : Int, callback: LoadDetailMovieCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onDetailMovieReceived(jsonHelper.loadMovieDetail(id))
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getDetailTvShow(id : Int, callback: LoadDetailTvShowCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onDetailTvShowReceived(jsonHelper.loadTvShowDetail(id))
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadMoviesCallback{
        fun onAllMoviesReceived(moviesResponse: List<ItemEntitySameWithResponse>)
    }

    interface LoadTvShowsCallback{
        fun onAllTvShowsReceived(tvShowsResponse: List<ItemEntitySameWithResponse>)
    }

    interface LoadDetailMovieCallback{
        fun onDetailMovieReceived(detailMovieResponse: ItemEntitySameWithResponse?)
    }

    interface LoadDetailTvShowCallback{
        fun onDetailTvShowReceived(detailTvShowResponse: ItemEntitySameWithResponse?)
    }

}

