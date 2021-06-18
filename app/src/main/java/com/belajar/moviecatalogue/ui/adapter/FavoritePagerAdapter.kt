package com.belajar.moviecatalogue.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.belajar.moviecatalogue.ui.detail.DetailViewModel.Companion.MOVIE
import com.belajar.moviecatalogue.ui.detail.DetailViewModel.Companion.TV_SHOW
import com.belajar.moviecatalogue.ui.favorite.MyFavoriteMovieAndTvShowFragment

class FavoritePagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    companion object {
        const val FAVORITE_MOVIE_POSITION = 0
        const val FAVORITE_TV_SHOW_POSITION = 1
        const val TAB_COUNT = 2
    }

    override fun getItemCount(): Int = TAB_COUNT

    override fun createFragment(position: Int): Fragment =
        when (position){
            FAVORITE_MOVIE_POSITION -> MyFavoriteMovieAndTvShowFragment.newInstance(MOVIE)
            FAVORITE_TV_SHOW_POSITION -> MyFavoriteMovieAndTvShowFragment.newInstance(TV_SHOW)
            else -> throw IllegalStateException("Invalid adapter position")
        }
}