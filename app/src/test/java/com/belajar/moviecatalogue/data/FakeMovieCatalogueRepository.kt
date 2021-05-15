package com.belajar.moviecatalogue.data

import com.belajar.moviecatalogue.data.source.MovieCatalogueDataSource
import com.belajar.moviecatalogue.data.source.remote.RemoteDataSource

class FakeMovieCatalogueRepository (private val remoteDataSource: RemoteDataSource) :
    MovieCatalogueDataSource
{
    override fun getAllMovies(): List<ItemEntity> {
        val movieResponse = remoteDataSource.getAllMovies()
        val movieList = ArrayList<ItemEntity>()
        for (response in movieResponse){
            val movie = ItemEntity(
                response.id,
                response.title,
                response.description,
                response.poster,
                response.release,
                response.rating,
                response.rating,
                response.crews
            )
            movieList.add(movie)
        }
        return movieList
    }

    override fun getAllTvShows(): List<ItemEntity> {
        val tvShowResponse = remoteDataSource.getAllTvShows()
        val tvShowList = ArrayList<ItemEntity>()
        for (response in tvShowResponse){
            val tvShow = ItemEntity(
                response.id,
                response.title,
                response.description,
                response.poster,
                response.release,
                response.rating,
                response.rating,
                response.crews
            )
            tvShowList.add(tvShow)
        }
        return tvShowList
    }

    override fun getDetailMovie(id: Int): ItemEntity? {
        return remoteDataSource.getDetailMovie(id)
    }

    override fun getDetailTvShow(id: Int): ItemEntity? {
        return remoteDataSource.getDetailTvShow(id)
    }
}