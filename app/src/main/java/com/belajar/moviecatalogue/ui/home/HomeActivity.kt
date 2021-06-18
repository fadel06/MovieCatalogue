package com.belajar.moviecatalogue.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.belajar.moviecatalogue.R
import com.belajar.moviecatalogue.databinding.ActivityHomeBinding
import com.belajar.moviecatalogue.ui.detail.DetailActivity.Companion.EXTRA_TYPE
import com.belajar.moviecatalogue.ui.detail.DetailViewModel.Companion.MOVIE
import com.belajar.moviecatalogue.ui.detail.DetailViewModel.Companion.TV_SHOW
import com.belajar.moviecatalogue.ui.favorite.MyFavoriteFragment
import com.belajar.moviecatalogue.ui.movieandtvshow.MovieAndTvShowFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId){
            R.id.navigationMovie -> {
                loadFragment(MovieAndTvShowFragment(), MOVIE)
            }
            R.id.navigationTvShow -> {
                loadFragment(MovieAndTvShowFragment(), TV_SHOW)
            }
            R.id.navigationFavorite -> {
                loadFragment(MyFavoriteFragment(), null)
            }
        }
        true
    }

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        loadFragment(MovieAndTvShowFragment(), MOVIE)
        setContentView(binding.root)

        val toolbar = binding.mToolbar
        binding.navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        setSupportActionBar(toolbar)


    }

    private fun loadFragment(fragment: Fragment?, type: String?): Boolean{
        if (fragment != null){
            val data = Bundle()
            data.putString(EXTRA_TYPE, type)
            fragment.arguments = data
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit()
        }
        return false
    }
}