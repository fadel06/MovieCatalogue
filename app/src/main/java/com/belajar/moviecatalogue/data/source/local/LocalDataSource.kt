package com.belajar.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import com.belajar.moviecatalogue.data.source.local.entity.MovieEntity
import com.belajar.moviecatalogue.data.source.local.entity.TvShowEntity
import com.belajar.moviecatalogue.data.source.local.room.MovieCatalogueDao

class LocalDataSource(private val mMovieCatalogueDao: MovieCatalogueDao) {
    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieCatalogueDao: MovieCatalogueDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieCatalogueDao)
    }

    fun getAllMovies(): LiveData<List<MovieEntity>> = mMovieCatalogueDao.getMovies()

    fun getMovieById(movieId : Int): LiveData<MovieEntity> = mMovieCatalogueDao.getMovieById(movieId)

    fun getFavMovie(): LiveData<List<MovieEntity>> = mMovieCatalogueDao.getFavMovie()

    fun insertMovie(movies: List<MovieEntity>) = mMovieCatalogueDao.insertMovies(movies)

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean){
        movie.isFavorite = newState
        mMovieCatalogueDao.updateMovie(movie)
    }

    fun updateMovie(movie: MovieEntity, newState: Boolean){
        movie.isFavorite = newState
        mMovieCatalogueDao.updateMovie(movie)
    }

    fun getAllTvShows(): LiveData<List<TvShowEntity>> = mMovieCatalogueDao.getTvShows()

    fun getTvShowById(tvShowId : Int): LiveData<TvShowEntity> = mMovieCatalogueDao.getTvShowById(tvShowId)

    fun getFavTvShow(): LiveData<List<TvShowEntity>> = mMovieCatalogueDao.getFavTvShow()

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