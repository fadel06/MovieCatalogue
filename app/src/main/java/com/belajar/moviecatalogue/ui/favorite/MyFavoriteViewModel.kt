package com.belajar.moviecatalogue.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.belajar.moviecatalogue.data.source.MovieCatalogueRepository
import com.belajar.moviecatalogue.data.source.local.entity.MovieEntity
import com.belajar.moviecatalogue.data.source.local.entity.TvShowEntity
import com.belajar.moviecatalogue.ui.detail.DetailViewModel.Companion.MOVIE
import com.belajar.moviecatalogue.ui.detail.DetailViewModel.Companion.TV_SHOW

class MyFavoriteViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) :
    ViewModel() {
    private lateinit var movieList: LiveData<PagedList<MovieEntity>>
    private lateinit var tvShowList: LiveData<PagedList<TvShowEntity>>

    fun setFavoriteItems(type: String?) {
        if (type != null) {
            when (type) {
                MOVIE -> movieList = movieCatalogueRepository.getFavoriteMovies()
                TV_SHOW -> tvShowList = movieCatalogueRepository.getFavoriteTvShows()
            }
        }
    }

    fun getFavoriteMovies() = movieList

    fun getFavoriteTvShows() = tvShowList

    fun setFavoriteMovie(movieEntity: MovieEntity) {
        val newState = !movieEntity.isFavorite
        movieCatalogueRepository.setFavoriteMovie(movieEntity, newState)
    }

    fun setFavoriteTvShow(tvShowEntity: TvShowEntity) {
        val newState = !tvShowEntity.isFavorite
        movieCatalogueRepository.setFavoriteTvShow(tvShowEntity, newState)
    }

}