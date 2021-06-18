package com.belajar.moviecatalogue.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.belajar.moviecatalogue.databinding.FragmentMyFavoriteBinding
import com.belajar.moviecatalogue.ui.adapter.FavoritePagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MyFavoriteFragment : Fragment() {

    private var _binding: FragmentMyFavoriteBinding? = null
    private val binding get() = _binding

    companion object{
        private val TAB_TITLES = listOf(
            "Movies",
            "Tv Show"
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
        val favoritePagerAdapter = FavoritePagerAdapter(requireActivity())
        val viewPager: ViewPager2? = binding?.viewPager
        viewPager?.isUserInputEnabled = false
        viewPager?.adapter = favoritePagerAdapter
        val tabs: TabLayout? = binding?.tabLayout
        if (tabs != null && viewPager != null) {
            TabLayoutMediator(tabs, viewPager){ tab, position ->
                tab.text = TAB_TITLES[position]
            }.attach()
        }
    }
}