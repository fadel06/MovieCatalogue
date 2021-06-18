package com.belajar.moviecatalogue.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.belajar.moviecatalogue.databinding.FragmentMyFavoriteMovieAndTvShowBinding
import com.belajar.moviecatalogue.ui.adapter.FavoriteMovieAdapter
import com.belajar.moviecatalogue.ui.adapter.FavoriteTvShowAdapter
import com.belajar.moviecatalogue.ui.detail.DetailActivity.Companion.EXTRA_TYPE
import com.belajar.moviecatalogue.ui.detail.DetailViewModel.Companion.MOVIE
import com.belajar.moviecatalogue.ui.detail.DetailViewModel.Companion.TV_SHOW
import com.belajar.moviecatalogue.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class MyFavoriteMovieAndTvShowFragment : Fragment() {
    companion object {

        @JvmStatic
        fun newInstance(type: String) =
            MyFavoriteMovieAndTvShowFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_TYPE, type)
                }
            }
    }

    private var type: String? = null
    private var _binding: FragmentMyFavoriteMovieAndTvShowBinding? = null
    private val binding get() = _binding
    private lateinit var viewModel: MyFavoriteViewModel
    private lateinit var movieAdapter: FavoriteMovieAdapter
    private lateinit var tvShowAdapter: FavoriteTvShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyFavoriteMovieAndTvShowBinding.inflate(inflater)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        type = arguments?.getString(EXTRA_TYPE)

        itemTouchHelper.attachToRecyclerView(binding?.rvFavoriteItem)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[MyFavoriteViewModel::class.java]
            if (type != null) {
                viewModel.setFavoriteItems(type)
                if (type == MOVIE) {
                    viewModel.getFavoriteMovies().observe(viewLifecycleOwner, { favoriteMovies ->
                        if (favoriteMovies != null) {
                            movieAdapter = FavoriteMovieAdapter()
                            movieAdapter.setItems(favoriteMovies, type)
                            binding?.rvFavoriteItem?.adapter = movieAdapter
                        }
                    })
                } else if (type == TV_SHOW) {
                    viewModel.getFavoriteTvShows().observe(viewLifecycleOwner, { favoriteTvShows ->
                        if (favoriteTvShows != null) {
                            tvShowAdapter = FavoriteTvShowAdapter()
                            tvShowAdapter.setItems(favoriteTvShows, type)
                            binding?.rvFavoriteItem?.adapter = tvShowAdapter
                        }
                    })
                }
            }
        }

    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.absoluteAdapterPosition
                val snackBar: Snackbar =
                    Snackbar.make(requireView(), "Batalkan", Snackbar.LENGTH_LONG)
                if (type == MOVIE) {
                    val movieEntity = movieAdapter.getSwipedData(swipedPosition)
                    movieEntity.let { viewModel.setFavMovie(it) }
                    snackBar.setAction("OK") {
                        movieEntity.let { viewModel.setFavMovie(it) }
                    }
                    snackBar.show()
                } else if (type == TV_SHOW) {
                    val tvShowEntity = tvShowAdapter.getSwipedData(swipedPosition)
                    tvShowEntity.let { viewModel.setFavTvShow(it) }
                    snackBar.setAction("OK") {
                        tvShowEntity.let { viewModel.setFavTvShow(it) }
                    }
                    snackBar.show()
                }

            }
        }
    })

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}