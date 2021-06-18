package com.belajar.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.belajar.moviecatalogue.data.source.local.entity.MovieEntity
import com.belajar.moviecatalogue.data.source.local.entity.TvShowEntity
import com.belajar.moviecatalogue.vo.Resource

interface MovieCatalogueDataSource {

    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getDetailMovie(movieId: Int) : LiveData<Resource<MovieEntity>>

    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>>

    fun setFavoriteMovie(movie: MovieEntity, state: Boolean)

    fun getAllTvShows(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getDetailTvShow(tvShowId: Int) : LiveData<Resource<TvShowEntity>>

    fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>>

    fun setFavoriteTvShow(tvShow: TvShowEntity, state: Boolean)

}