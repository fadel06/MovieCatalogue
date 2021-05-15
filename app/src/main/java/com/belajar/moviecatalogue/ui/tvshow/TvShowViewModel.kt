package com.belajar.moviecatalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import com.belajar.moviecatalogue.utils.Data
import com.belajar.moviecatalogue.data.TvShowEntity

class TvShowViewModel : ViewModel() {
    fun getTvShows() : List<TvShowEntity> = Data.generateTvShows()
}