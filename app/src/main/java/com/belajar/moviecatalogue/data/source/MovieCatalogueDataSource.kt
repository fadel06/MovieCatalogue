package com.belajar.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.belajar.moviecatalogue.data.source.local.entity.MovieEntity
import com.belajar.moviecatalogue.data.source.local.entity.TvShowEntity
import com.belajar.moviecatalogue.vo.Resource

interface MovieCatalogueDataSource {

    fun getAllMovies(): LiveData<Resource<List<MovieEntity>>>

    fun getDetailMovie(movieId: Int) : LiveData<Resource<MovieEntity>>

    fun getFavoriteMovies(): LiveData<List<MovieEntity>>

    fun setFavoriteMovie(movie: MovieEntity, state: Boolean)

    fun getAllTvShows(): LiveData<Resource<List<TvShowEntity>>>

    fun getDetailTvShow(tvShowId: Int) : LiveData<Resource<TvShowEntity>>

    fun getFavoriteTvShows(): LiveData<List<TvShowEntity>>

    fun setFavoriteTvShow(tvShow: TvShowEntity, state: Boolean)

}