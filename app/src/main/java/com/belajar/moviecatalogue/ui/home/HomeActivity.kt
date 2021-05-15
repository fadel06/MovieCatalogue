package com.belajar.moviecatalogue.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.belajar.moviecatalogue.R
import com.belajar.moviecatalogue.databinding.ActivityHomeBinding
import com.belajar.moviecatalogue.ui.movie.MovieFragment
import com.belajar.moviecatalogue.ui.tvshow.TvShowFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId){
            R.id.navigationMovie -> loadFragment(MovieFragment())
            R.id.navigationTvShow -> loadFragment(TvShowFragment())
        }
        true
    }

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        loadFragment(MovieFragment())
        setContentView(binding.root)

        binding.navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        setSupportActionBar(binding.mToolbar)


    }

    private fun loadFragment(fragment: Fragment?): Boolean{
        if (fragment != null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit()
        }
        return false
    }
}