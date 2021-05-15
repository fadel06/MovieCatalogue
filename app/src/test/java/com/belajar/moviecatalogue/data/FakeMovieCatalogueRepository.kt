package com.belajar.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.belajar.moviecatalogue.data.source.MovieCatalogueDataSource
import com.belajar.moviecatalogue.data.source.remote.RemoteDataSource

class FakeMovieCatalogueRepository (private val remoteDataSource: RemoteDataSource) :
    MovieCatalogueDataSource
{
    override fun getAllMovies(): LiveData<List<ItemEntitySameWithResponse>> {
        val moviesResult = MutableLiveData<List<ItemEntitySameWithResponse>>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(moviesResponse: List<ItemEntitySameWithResponse>) {
                val movieList = ArrayList<ItemEntitySameWithResponse>()
                for (response in moviesResponse){
                    val movie = ItemEntitySameWithResponse(
                        response.id,
                        response.title,
                        response.description,
                        response.poster,
                        response.release,
                        response.rating,
                        response.trailer,
                        response.crews
                    )
                    movieList.add(movie)
                }
                moviesResult.postValue(movieList)
            }
        })
        return moviesResult
    }

    override fun getAllTvShows(): LiveData<List<ItemEntitySameWithResponse>> {
        val tvShowsResult = MutableLiveData<List<ItemEntitySameWithResponse>>()
        remoteDataSource.getAllTvShows(object : RemoteDataSource.LoadTvShowsCallback{
            override fun onAllTvShowsReceived(tvShowsResponse: List<ItemEntitySameWithResponse>) {
                val tvShowList = ArrayList<ItemEntitySameWithResponse>()
                for (response in tvShowsResponse){
                    val tvShow = ItemEntitySameWithResponse(
                        response.id,
                        response.title,
                        response.description,
                        response.poster,
                        response.release,
                        response.rating,
                        response.trailer,
                        response.crews
                    )
                    tvShowList.add(tvShow)
                }
                tvShowsResult.postValue(tvShowList)
            }

        })
        return tvShowsResult
    }

    override fun getDetailMovie(id: Int): LiveData<ItemEntitySameWithResponse?> {
        val movieResult = MutableLiveData<ItemEntitySameWithResponse>()
        remoteDataSource.getDetailMovie(id, object : RemoteDataSource.LoadDetailMovieCallback {
            override fun onDetailMovieReceived(detailMovieResponse: ItemEntitySameWithResponse?) {
                val movie = ItemEntitySameWithResponse(
                    detailMovieResponse?.id,
                    detailMovieResponse?.title,
                    detailMovieResponse?.description,
                    detailMovieResponse?.poster,
                    detailMovieResponse?.release,
                    detailMovieResponse?.rating,
                    detailMovieResponse?.trailer,
                    detailMovieResponse?.crews
                )
                movieResult.postValue(movie)
            }
        })
        return movieResult
    }

    override fun getDetailTvShow(id: Int): LiveData<ItemEntitySameWithResponse?> {
        val tvShowResult = MutableLiveData<ItemEntitySameWithResponse>()
        remoteDataSource.getDetailTvShow(id, object : RemoteDataSource.LoadDetailTvShowCallback {
            override fun onDetailTvShowReceived(detailTvShowResponse: ItemEntitySameWithResponse?) {
                val tvShow = ItemEntitySameWithResponse(
                    detailTvShowResponse?.id,
                    detailTvShowResponse?.title,
                    detailTvShowResponse?.description,
                    detailTvShowResponse?.poster,
                    detailTvShowResponse?.release,
                    detailTvShowResponse?.rating,
                    detailTvShowResponse?.trailer,
                    detailTvShowResponse?.crews
                )
                tvShowResult.postValue(tvShow)
            }
        })
        return tvShowResult
    }
}