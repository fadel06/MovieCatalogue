package com.belajar.moviecatalogue.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.belajar.moviecatalogue.R
import com.belajar.moviecatalogue.data.source.local.entity.MovieEntity
import com.belajar.moviecatalogue.data.source.local.entity.TvShowEntity
import com.belajar.moviecatalogue.databinding.ActivityDetailBinding
import com.belajar.moviecatalogue.ui.adapter.CrewAdapter
import com.belajar.moviecatalogue.ui.detail.DetailViewModel.Companion.MOVIE
import com.belajar.moviecatalogue.ui.detail.DetailViewModel.Companion.TV_SHOW
import com.belajar.moviecatalogue.utils.errorMessage
import com.belajar.moviecatalogue.utils.getIdDrawable
import com.belajar.moviecatalogue.utils.visibility
import com.belajar.moviecatalogue.viewmodel.ViewModelFactory
import com.belajar.moviecatalogue.vo.Status
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ID_ITEM = "extra_id_item"
        const val EXTRA_TYPE = "extra_type"
    }

    private val crewAdapter = CrewAdapter()
    private lateinit var detailViewModel: DetailViewModel
    private lateinit var binding: ActivityDetailBinding
    private var menu: Menu? = null
    private var itemId: Int = 0
    private var type: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.mToolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.navigationIcon =
            ResourcesCompat.getDrawable(resources, R.drawable.ic_arrow_back, null)
        toolbar.setNavigationOnClickListener {
            finish()
        }
        val factory = ViewModelFactory.getInstance(this)
        detailViewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            itemId = extras.getInt(EXTRA_ID_ITEM)
            type = extras.getString(EXTRA_TYPE).toString()

            if (itemId != 0 && type != "") {
                detailViewModel.setItem(itemId, type)
                if (type == MOVIE) {
                    detailViewModel.getMovie().observe(this, { movie ->
                        if (movie != null) {
                            binding.mLoading.mProgressBar visibility true
                            when (movie.status) {
                                Status.LOADING -> binding.mLoading.mProgressBar visibility true
                                Status.SUCCESS -> {
                                    if (movie.data != null) {
                                        binding.mLoading.mProgressBar visibility false
                                        populateDataDetail(movie.data)
                                    }
                                }
                                Status.ERROR -> {
                                    binding.mLoading.mProgressBar visibility false
                                    errorMessage(applicationContext)
                                }
                            }
                        }
                    })
                } else if (type == TV_SHOW) {
                    detailViewModel.getTvShow().observe(this, { tvShow ->
                        if (tvShow != null) {
                            binding.mLoading.mProgressBar visibility true
                            when (tvShow.status) {
                                Status.LOADING -> binding.mLoading.mProgressBar visibility true
                                Status.SUCCESS -> {
                                    if (tvShow.data != null) {
                                        binding.mLoading.mProgressBar visibility false
                                        populateDataDetail(tvShow.data)
                                    }
                                }
                                Status.ERROR -> {
                                    binding.mLoading.mProgressBar visibility false
                                    errorMessage(applicationContext)
                                }
                            }
                        }
                    })
                }
            }
        }

        binding.rvCrew.apply {
            layoutManager =
                LinearLayoutManager(this@DetailActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = crewAdapter
        }
    }

    @JvmName("populateDataDetailForMovie")
    private fun populateDataDetail(movie: MovieEntity) {
        with(movie) {
            supportActionBar?.title = this.title
            Glide.with(this@DetailActivity)
                .load(getIdDrawable(this@DetailActivity, this.poster))
                .into(binding.imgPoster)
            Glide.with(this@DetailActivity)
                .load(getIdDrawable(this@DetailActivity, this.poster))
                .into(binding.imgBgPoster)
            binding.tvTitle.text = this.title
            binding.tvReleaseDate.text = this.release
            binding.tvRating.text = this.rating
            binding.progressRating.progress = this.rating.toInt()
            binding.tvOverview.text = this.description
            binding.btnTrailer.setOnClickListener {
                val intent =
                    Intent(Intent.ACTION_VIEW, Uri.parse(this.trailer))
                startActivity(intent)
            }
            val crews = detailViewModel.getMovieCrews(this)
            crewAdapter.setCrews(crews)
            crewAdapter.notifyDataSetChanged()
//            binding.rvCrew.adapter = crewAdapter
            binding.mLoading.mProgressBar visibility false
        }
    }

    @JvmName("populateDataDetailForTvShow")
    private fun populateDataDetail(tvShow: TvShowEntity) {
        with(tvShow) {
            supportActionBar?.title = this.title
            Glide.with(this@DetailActivity)
                .load(getIdDrawable(this@DetailActivity, this.poster))
                .into(binding.imgPoster)
            Glide.with(this@DetailActivity)
                .load(getIdDrawable(this@DetailActivity, this.poster))
                .into(binding.imgBgPoster)
            binding.tvTitle.text = this.title
            binding.tvReleaseDate.text = this.release
            binding.tvRating.text = this.rating
            binding.progressRating.progress = this.rating.toInt()
            binding.tvOverview.text = this.description
            binding.btnTrailer.setOnClickListener {
                val intent =
                    Intent(Intent.ACTION_VIEW, Uri.parse(this.trailer))
                startActivity(intent)
            }
            val crews = detailViewModel.getTvShowCrews(this)
            crewAdapter.setCrews(crews)
            crewAdapter.notifyDataSetChanged()
//            binding.rvCrew.adapter = crewAdapter
            binding.mLoading.mProgressBar visibility false
        }
    }


    private fun setUpState() {
        if (type == MOVIE) {
            detailViewModel.getMovie().observe(this, { movie ->
                when (movie.status) {
                    Status.LOADING -> binding.mLoading.mProgressBar visibility true
                    Status.SUCCESS -> {
                        if (movie.data != null) {
                            binding.mLoading.mProgressBar visibility false
                            val state = movie.data.isFavorite
                            setFavoriteState(state)
                        }
                    }
                    Status.ERROR -> {
                        binding.mLoading.mProgressBar visibility false
                        errorMessage(applicationContext)
                    }
                }
            })
        } else if (type == TV_SHOW) {
            detailViewModel.getTvShow().observe(this, { tvShow ->
                when (tvShow.status) {
                    Status.LOADING -> binding.mLoading.mProgressBar visibility true
                    Status.SUCCESS -> {
                        if (tvShow.data != null) {
                            binding.mLoading.mProgressBar visibility false
                            val state = tvShow.data.isFavorite
                            setFavoriteState(state)
                        }
                    }
                    Status.ERROR -> {
                        binding.mLoading.mProgressBar visibility false
                        errorMessage(applicationContext)
                    }
                }
            })
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.favorite_menu, menu)
        this.menu = menu
        setUpState()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            if (type == MOVIE) {
                detailViewModel.setMovieFavorite()
            } else if (type == TV_SHOW) {
                detailViewModel.setTvShowFavorite()
            }
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFavoriteState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_border)
        }
    }
}