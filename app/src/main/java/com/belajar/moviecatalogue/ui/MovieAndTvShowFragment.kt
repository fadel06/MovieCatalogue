package com.belajar.moviecatalogue.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.belajar.moviecatalogue.data.ItemEntity
import com.belajar.moviecatalogue.databinding.MovieAndTvShowFragmentBinding
import com.belajar.moviecatalogue.ui.adapter.ItemAdapter
import com.belajar.moviecatalogue.ui.detail.DetailActivity.Companion.EXTRA_MOVIE
import com.belajar.moviecatalogue.ui.movie.MovieViewModel
import com.belajar.moviecatalogue.ui.tvshow.TvShowViewModel
import com.belajar.moviecatalogue.utils.visibility
import com.belajar.moviecatalogue.viewmodel.ViewModelFactory

class MovieAndTvShowFragment : Fragment() {

    private var type: String? = null
    private var _binding : MovieAndTvShowFragmentBinding? = null
    private val binding get() = _binding

    companion object {
        const val EXTRA_TYPE = "extra_type"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null){
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
            val itemList: List<ItemEntity>
            val spanCount: Int
            when {
                type?.equals(EXTRA_MOVIE) == true -> {
                    val movieViewModel = ViewModelProvider(
                        this,
                        factory
                    )[MovieViewModel::class.java]
                    itemList = movieViewModel.getMovies()
                    spanCount = 2
                }
                else -> {
                    val tvShowViewModel = ViewModelProvider(
                        this,
                        factory
                    )[TvShowViewModel::class.java]
                    itemList = tvShowViewModel.getTvShows()
                    spanCount = 3
                }
            }
            val itemAdapter = ItemAdapter()
            binding?.mLoading?.mProgressBar?.visibility(true)
            itemAdapter.setItems(itemList, type)
            binding?.mLoading?.mProgressBar?.visibility(false)


            binding?.mRecyclerView?.apply {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(context, spanCount)
                adapter = itemAdapter
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}