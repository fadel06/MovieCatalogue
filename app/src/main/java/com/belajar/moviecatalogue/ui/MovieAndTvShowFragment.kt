package com.belajar.moviecatalogue.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.belajar.moviecatalogue.data.ItemEntitySameWithResponse
import com.belajar.moviecatalogue.databinding.MovieAndTvShowFragmentBinding
import com.belajar.moviecatalogue.ui.adapter.ItemAdapter
import com.belajar.moviecatalogue.ui.detail.DetailActivity.Companion.EXTRA_MOVIE
import com.belajar.moviecatalogue.ui.movie.MovieViewModel
import com.belajar.moviecatalogue.ui.tvshow.TvShowViewModel
import com.belajar.moviecatalogue.utils.visibility
import com.belajar.moviecatalogue.viewmodel.ViewModelFactory

class MovieAndTvShowFragment : Fragment() {

    private var type: String? = null
    private var _binding: MovieAndTvShowFragmentBinding? = null
    private val binding get() = _binding
    private var itemList: List<ItemEntitySameWithResponse>? = null
    private val itemAdapter = ItemAdapter()

    companion object {
        const val EXTRA_TYPE = "extra_type"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            type = arguments?.getString(EXTRA_TYPE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FrameLayout? {
        _binding = MovieAndTvShowFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val spanCount: Int
            when {
                type?.equals(EXTRA_MOVIE) == true -> {
                    val movieViewModel = ViewModelProvider(
                        this,
                        factory
                    )[MovieViewModel::class.java]
                    spanCount = 2
                    loadMovies(movieViewModel)
                }
                else -> {
                    val tvShowViewModel = ViewModelProvider(
                        this,
                        factory
                    )[TvShowViewModel::class.java]
                    spanCount = 3
                    loadTvShows(tvShowViewModel)
                }
            }




            binding?.mRecyclerView?.apply {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(context, spanCount)
                adapter = itemAdapter
            }

        }
    }

    private fun loadTvShows(tvShowViewModel: TvShowViewModel) {
        binding?.mLoading?.mProgressBar?.visibility(true)

        tvShowViewModel.getTvShows().observe(this, { tvShows ->
            itemList = tvShows
            itemAdapter.setItems(itemList, type)
            binding?.mRecyclerView?.adapter = itemAdapter
            binding?.mLoading?.mProgressBar?.visibility(false)
        })
    }

    private fun loadMovies(movieViewModel: MovieViewModel) {
        binding?.mLoading?.mProgressBar?.visibility(true)

        movieViewModel.getMovies().observe(this, { movies ->
            itemList = movies
            itemAdapter.setItems(itemList, type)
            binding?.mRecyclerView?.adapter = itemAdapter
            binding?.mLoading?.mProgressBar?.visibility(false)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}