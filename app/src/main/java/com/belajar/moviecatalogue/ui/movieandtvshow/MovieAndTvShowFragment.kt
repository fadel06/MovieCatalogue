package com.belajar.moviecatalogue.ui.movieandtvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import com.belajar.moviecatalogue.data.source.local.entity.MovieEntity
import com.belajar.moviecatalogue.data.source.local.entity.TvShowEntity
import com.belajar.moviecatalogue.databinding.FragmentMovieAndTvShowBinding
import com.belajar.moviecatalogue.ui.adapter.MovieAdapter
import com.belajar.moviecatalogue.ui.adapter.TvShowAdapter
import com.belajar.moviecatalogue.ui.detail.DetailActivity.Companion.EXTRA_TYPE
import com.belajar.moviecatalogue.ui.detail.DetailViewModel.Companion.MOVIE
import com.belajar.moviecatalogue.ui.detail.DetailViewModel.Companion.TV_SHOW
import com.belajar.moviecatalogue.utils.errorMessage
import com.belajar.moviecatalogue.utils.visibility
import com.belajar.moviecatalogue.viewmodel.ViewModelFactory
import com.belajar.moviecatalogue.vo.Status

class MovieAndTvShowFragment : Fragment() {

    private var type: String? = null
    private var _binding: FragmentMovieAndTvShowBinding? = null
    private val binding get() = _binding
    private var movieList: PagedList<MovieEntity>? = null
    private var tvShowList: PagedList<TvShowEntity>? = null
    private val movieAdapter = MovieAdapter()
    private val tvShowAdapter = TvShowAdapter()
    private var viewModel: MovieAndTvShowViewModel? = null

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
        _binding = FragmentMovieAndTvShowBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(
                this,
                factory
            )[MovieAndTvShowViewModel::class.java]

            if (type != null) {
                viewModel?.setItems(type.toString())
                when (type) {
                    MOVIE -> {
                        viewModel?.getMovies()?.observe(viewLifecycleOwner, { movies ->
                            if (movies != null) {
                                binding?.mLoading?.mProgressBar?.visibility(true)
                                when (movies.status) {
                                    Status.LOADING -> binding?.mLoading?.mProgressBar?.visibility(
                                        true
                                    )
                                    Status.SUCCESS -> {
                                        if (movies.data != null) {
                                            binding?.mLoading?.mProgressBar?.visibility(false)
                                            binding?.mRecyclerView?.apply {
                                                adapter = movieAdapter
                                                setHasFixedSize(true)
                                                layoutManager = GridLayoutManager(context, 2)
                                            }
                                            populateDataList(movies.data)
                                        }
                                    }
                                    Status.ERROR -> {
                                        binding?.mLoading?.mProgressBar?.visibility(false)
                                        context?.let { errorMessage(it) }
                                    }
                                }
                            }
                        })
                    }
                    TV_SHOW -> {
                        viewModel?.getTvShows()?.observe(viewLifecycleOwner, { tvShows ->
                            if (tvShows != null) {
                                binding?.mLoading?.mProgressBar?.visibility(true)
                                when (tvShows.status) {
                                    Status.LOADING -> binding?.mLoading?.mProgressBar?.visibility(
                                        true
                                    )
                                    Status.SUCCESS -> {
                                        if (tvShows.data != null) {
                                            binding?.mLoading?.mProgressBar?.visibility(false)
                                            binding?.mRecyclerView?.apply {
                                                adapter = tvShowAdapter
                                                setHasFixedSize(true)
                                                layoutManager = GridLayoutManager(context, 3)
                                            }
                                            populateDataList(tvShows.data)
                                        }
                                    }
                                    Status.ERROR -> {
                                        binding?.mLoading?.mProgressBar?.visibility(false)
                                        context?.let { errorMessage(it) }
                                    }
                                }
                            }
                        })
                    }
                }
            }
        }
    }

    @JvmName("populateDataForMovieList")
    private fun populateDataList(movies: PagedList<MovieEntity>) {
        movieList = movies
        movieAdapter.getType(type)
        movieAdapter.submitList(movieList)
        movieAdapter.notifyDataSetChanged()
    }

    @JvmName("populateDataForTvShowList")
    private fun populateDataList(tvShows: PagedList<TvShowEntity>) {
        tvShowList = tvShows
        tvShowAdapter.getType(type)
        tvShowAdapter.submitList(tvShowList)
        tvShowAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}