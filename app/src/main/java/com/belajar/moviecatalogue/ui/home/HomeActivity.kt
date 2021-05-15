package com.belajar.moviecatalogue.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.belajar.moviecatalogue.R
import com.belajar.moviecatalogue.databinding.ActivityHomeBinding
import com.belajar.moviecatalogue.ui.MovieAndTvShowFragment
import com.belajar.moviecatalogue.ui.MovieAndTvShowFragment.Companion.EXTRA_TYPE
import com.belajar.moviecatalogue.ui.detail.DetailActivity.Companion.EXTRA_MOVIE
import com.belajar.moviecatalogue.ui.detail.DetailActivity.Companion.EXTRA_TV_SHOW
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId){
            R.id.navigationMovie -> {
                loadFragment(MovieAndTvShowFragment(), EXTRA_MOVIE)
            }
            R.id.navigationTvShow -> {
                loadFragment(MovieAndTvShowFragment(), EXTRA_TV_SHOW)
            }
        }
        true
    }

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        loadFragment(MovieAndTvShowFragment(), EXTRA_MOVIE)
        setContentView(binding.root)

        binding.navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        setSupportActionBar(binding.mToolbar)


    }

    private fun loadFragment(fragment: Fragment?, type: String): Boolean{
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