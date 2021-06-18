package com.belajar.moviecatalogue.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.belajar.moviecatalogue.R
import com.belajar.moviecatalogue.databinding.FragmentMyFavoriteBinding
import com.belajar.moviecatalogue.ui.adapter.FavoritePagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MyFavoriteFragment : Fragment() {

    private var _binding: FragmentMyFavoriteBinding? = null
    private val binding get() = _binding

    companion object{
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.movie,
            R.string.tv_show
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyFavoriteBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val favoritePagerAdapter = activity?.let { FavoritePagerAdapter(it) }
        val viewPager: ViewPager2? = binding?.viewPager
        viewPager?.adapter = favoritePagerAdapter
        val tabs: TabLayout? = binding?.tabLayout
        if (tabs != null && viewPager != null) {
            TabLayoutMediator(tabs, viewPager){ tab, position ->
                tab.text = resources.getString(TAB_TITLES[position])
            }.attach()
        }
    }
}