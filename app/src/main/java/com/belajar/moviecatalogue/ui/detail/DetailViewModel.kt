package com.belajar.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.belajar.moviecatalogue.data.source.MovieCatalogueRepository
import com.belajar.moviecatalogue.data.source.local.entity.*
import com.belajar.moviecatalogue.vo.Resource

class DetailViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) :
    ViewModel() {

    companion object {
        const val MOVIE = "movie"
        const val TV_SHOW = "tv_show"
    }

    private lateinit var detailMovie: LiveData<Resource<MovieEntity>>
    private lateinit var detailTvShow: LiveData<Resource<TvShowEntity>>

    fun setItem(id: Int, type: String){
        when (type){
            MOVIE -> detailMovie = movieCatalogueRepository.getDetailMovie(id)
            TV_SHOW -> detailTvShow = movieCatalogueRepository.getDetailTvShow(id)
        }
    }


    fun getMovieCrews(movie: MovieEntity?): List<CrewEntity>? = movie?.crewEntity

    fun setMovieFavorite() {
        val movieResource = detailMovie.value
        if (movieResource?.data != null) {
            val newState = !movieResource.data.isFavorite
            movieCatalogueRepository.setFavoriteMovie(movieResource.data, newState)
        }
    }

    fun getTvShowCrews(tvShow: TvShowEntity?): List<CrewEntity>? = tvShow?.crewEntity

    fun setTvShowFavorite() {
        val tvShowResource = detailTvShow.value
        if (tvShowResource?.data != null) {
            val newState = !tvShowResource.data.isFavorite
            movieCatalogueRepository.setFavoriteTvShow(tvShowResource.data, newState)
        }
    }

    fun getMovie() = detailMovie
    fun getTvShow() = detailTvShow
}

