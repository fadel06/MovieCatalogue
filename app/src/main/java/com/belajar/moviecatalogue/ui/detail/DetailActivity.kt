package com.belajar.moviecatalogue.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.belajar.moviecatalogue.R
import com.belajar.moviecatalogue.data.MovieEntity
import com.belajar.moviecatalogue.data.TvShowEntity
import com.belajar.moviecatalogue.databinding.ActivityDetailBinding
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

        detailViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val movieId = intent.getIntExtra(EXTRA_MOVIE, 0)
        val tvShowId = intent.getIntExtra(EXTRA_TV_SHOW, 0)
        if (movieId != 0) {
            loadDataMovie(detailViewModel.getMovieDetail(movieId))
        } else {
            loadDataTvShow(detailViewModel.getTvShowDetail(tvShowId))
        }

        binding.rvCrew.apply {
            layoutManager = LinearLayoutManager(this@DetailActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = mAdapter
        }
    }

    private fun loadDataMovie(movie: MovieEntity?) {
        binding.apply {
            supportActionBar?.title = movie?.movieTitle
            Glide.with(this@DetailActivity).load(movie?.moviePoster).into(imgPoster)
            Glide.with(this@DetailActivity).load(movie?.moviePoster).into(imgBgPoster)
            tvTitle.text = movie?.movieTitle
            tvReleaseDate.text = movie?.movieRelease
            tvRating.text = movie?.movieRating
            progressRating.progress = movie?.movieRating?.toInt() ?: 0
            tvOverview.text = movie?.movieDescription
            btnTrailer.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(movie?.movieTrailer))
                startActivity(intent)
            }
        }
        val crews = detailViewModel.getMovieCrews(movie)
        mAdapter.setCrews(crews)

    }

    private fun loadDataTvShow(tvShow: TvShowEntity?) {
        binding.apply {
            supportActionBar?.title = tvShow?.tvShowTitle
            Glide.with(this@DetailActivity).load(tvShow?.tvShowPoster).into(imgPoster)
            Glide.with(this@DetailActivity).load(tvShow?.tvShowPoster).into(imgBgPoster)
            tvTitle.text = tvShow?.tvShowTitle
            tvReleaseDate.text = tvShow?.tvShowRelease
            tvRating.text = tvShow?.tvShowRating
            progressRating.progress = tvShow?.tvShowRating?.toInt() ?: 0
            tvOverview.text = tvShow?.tvShowDescription
            btnTrailer.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(tvShow?.tvShowTrailer))
                startActivity(intent)
            }
        }
        val crews = detailViewModel.getTvShowCrews(tvShow)
        mAdapter.setCrews(crews)
    }
}