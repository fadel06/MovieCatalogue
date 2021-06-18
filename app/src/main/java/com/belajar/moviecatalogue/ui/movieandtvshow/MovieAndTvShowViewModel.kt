package com.belajar.moviecatalogue.ui.movieandtvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.belajar.moviecatalogue.data.source.local.entity.MovieEntity
import com.belajar.moviecatalogue.data.source.local.entity.TvShowEntity
import com.belajar.moviecatalogue.data.source.MovieCatalogueRepository
import com.belajar.moviecatalogue.ui.detail.DetailViewModel.Companion.MOVIE
import com.belajar.moviecatalogue.ui.detail.DetailViewModel.Companion.TV_SHOW
import com.belajar.moviecatalogue.vo.Resource

class MovieAndTvShowViewModel (private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel()  {

    private lateinit var movieList: LiveData<Resource<PagedList<MovieEntity>>>
    private lateinit var tvShowList: LiveData<Resource<PagedList<TvShowEntity>>>

    fun setItems(type: String?){
        if (type != null) {
            when (type) {
                MOVIE -> movieList = movieCatalogueRepository.getAllMovies()
                TV_SHOW -> tvShowList = movieCatalogueRepository.getAllTvShows()
            }
        }
    }
    fun getMovies() = movieList

    fun getTvShows() = tvShowList
}