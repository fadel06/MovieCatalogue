package com.belajar.moviecatalogue.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.belajar.moviecatalogue.R
import com.belajar.moviecatalogue.databinding.ActivityDetailBinding
import com.belajar.moviecatalogue.ui.adapter.CrewAdapter
import com.belajar.moviecatalogue.utils.visibility
import com.belajar.moviecatalogue.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    private val mAdapter = CrewAdapter()
    private lateinit var  detailViewModel : DetailViewModel

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.mToolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.navigationIcon = ResourcesCompat.getDrawable(resources, R.drawable.ic_arrow_back, null)
        toolbar.setNavigationOnClickListener {
            finish()
        }
        val factory = ViewModelFactory.getInstance(this)
        detailViewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val movieId = intent.getIntExtra(EXTRA_MOVIE, 0)
        val tvShowId = intent.getIntExtra(EXTRA_TV_SHOW, 0)
        if (movieId != 0) {
            loadDataMovie(movieId)
        } else {
            loadDataTvShow(tvShowId)
        }

        binding.rvCrew.apply {
            layoutManager = LinearLayoutManager(this@DetailActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = mAdapter
        }
    }

    private fun loadDataMovie(movieId: Int) {
        binding.mLoading.mProgressBar visibility true
        detailViewModel.getMovieDetail(movieId).observe(this, {
            movie ->
            binding.apply {
                supportActionBar?.title = movie?.title
                Glide.with(this@DetailActivity).load(getIdResources(movie?.poster)).into(imgPoster)
                Glide.with(this@DetailActivity).load(getIdResources(movie?.poster)).into(imgBgPoster)
                tvTitle.text = movie?.title
                tvReleaseDate.text = movie?.release
                tvRating.text = movie?.rating
                progressRating.progress = movie?.rating?.toInt() ?: 0
                tvOverview.text = movie?.description
                btnTrailer.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(movie?.trailer))
                    startActivity(intent)
                }
            }
            val crews = detailViewModel.getMovieCrews(movie)
            mAdapter.setCrews(crews)
            binding.rvCrew.adapter = mAdapter
            binding.mLoading.mProgressBar visibility false

        })
    }

    private fun loadDataTvShow(tvShowId: Int) {
        binding.mLoading.mProgressBar visibility true
        detailViewModel.getTvShowDetail(tvShowId).observe(this,{
            tvShow ->
            binding.apply {
                supportActionBar?.title = tvShow?.title
                Glide.with(this@DetailActivity).load(getIdResources(tvShow?.poster)).into(imgPoster)
                Glide.with(this@DetailActivity).load(getIdResources(tvShow?.poster)).into(imgBgPoster)
                tvTitle.text = tvShow?.title
                tvReleaseDate.text = tvShow?.release
                tvRating.text = tvShow?.rating
                progressRating.progress = tvShow?.rating?.toInt() ?: 0
                tvOverview.text = tvShow?.description
                btnTrailer.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(tvShow?.trailer))
                    startActivity(intent)
                }
            }
            val crews = detailViewModel.getTvShowCrews(tvShow)
            mAdapter.setCrews(crews)
            binding.rvCrew.adapter = mAdapter
            binding.mLoading.mProgressBar visibility false
        })
    }

    private fun getIdResources(name : String?) : Int {
        return resources.getIdentifier(name, "drawable", packageName)
    }
}