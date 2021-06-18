package com.belajar.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.belajar.moviecatalogue.data.source.local.entity.MovieEntity
import com.belajar.moviecatalogue.data.source.local.entity.TvShowEntity
import com.belajar.moviecatalogue.data.source.local.room.MovieCatalogueDao

class LocalDataSource(private val mMovieCatalogueDao: MovieCatalogueDao) {
    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieCatalogueDao: MovieCatalogueDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieCatalogueDao)
    }

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mMovieCatalogueDao.getMovies()

    fun getMovieById(movieId : Int): LiveData<MovieEntity> = mMovieCatalogueDao.getMovieById(movieId)

    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity> = mMovieCatalogueDao.getFavoriteMovie()

    fun insertMovie(movies: List<MovieEntity>) = mMovieCatalogueDao.insertMovies(movies)

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean){
        movie.isFavorite = newState
        mMovieCatalogueDao.updateMovie(movie)
    }

    fun updateMovie(movie: MovieEntity, newState: Boolean){
        movie.isFavorite = newState
        mMovieCatalogueDao.updateMovie(movie)
    }

    fun getAllTvShows(): DataSource.Factory<Int, TvShowEntity> = mMovieCatalogueDao.getTvShows()

    fun getTvShowById(tvShowId : Int): LiveData<TvShowEntity> = mMovieCatalogueDao.getTvShowById(tvShowId)

    fun getFavoriteTvShow(): DataSource.Factory<Int, TvShowEntity> = mMovieCatalogueDao.getFavoriteTvShow()

    fun insertTvShow(tvShows: List<TvShowEntity>) = mMovieCatalogueDao.insertTvShows(tvShows)

    fun setFavoriteTvShow(tvShow: TvShowEntity, newState: Boolean){
        tvShow.isFavorite = newState
        mMovieCatalogueDao.updateTvShow(tvShow)
    }

    fun updateTvShow(tvShow: TvShowEntity, newState: Boolean){
        tvShow.isFavorite = newState
        mMovieCatalogueDao.updateTvShow(tvShow)
    }
}