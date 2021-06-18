package com.belajar.moviecatalogue.data.source.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.belajar.moviecatalogue.data.source.local.entity.MovieEntity
import com.belajar.moviecatalogue.data.source.local.entity.TvShowEntity
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

    fun getAllMovies(): LiveData<ApiResponse<List<MovieEntity>>> {
        EspressoIdlingResource.increment()
        val resultMovies = MutableLiveData<ApiResponse<List<MovieEntity>>>()
        handler.postDelayed({
            resultMovies.value = ApiResponse.success(jsonHelper.loadMovies())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovies
    }

    fun getAllTvShows(): LiveData<ApiResponse<List<TvShowEntity>>> {
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<TvShowEntity>>>()
        handler.postDelayed({
            resultTvShow.value = ApiResponse.success(jsonHelper.loadTvShows())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultTvShow
    }

    fun getDetailMovie(movieId : Int): LiveData<ApiResponse<MovieEntity>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<MovieEntity>>()
        handler.postDelayed({
            resultMovie.value = ApiResponse.success(jsonHelper.loadMovieDetail(movieId))
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovie
    }

    fun getDetailTvShow(tvShowId: Int): LiveData<ApiResponse<TvShowEntity>> {
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<TvShowEntity>>()
        handler.postDelayed({
            resultTvShow.value = ApiResponse.success(jsonHelper.loadTvShowDetail(tvShowId))
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultTvShow
    }
}

