package com.example.bambini.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bambini.databinding.FragmentHomeBinding
import com.example.bambini.homeRecyclerView.HomeRecyclerViewAdapter
import com.example.bambini.viewmodel.LandingViewModel
import com.example.bambinifashion.home.HomeViewPagerAdapter
import com.example.bambinifashion.viewmodel.PromotionViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val promotionAdapter by lazy { HomeViewPagerAdapter() }
    private val viewModelPromotion: PromotionViewModel by viewModels()
    private val viewModelLanding: LandingViewModel by viewModels()
    private val homeRecyclerViewAdapter by lazy { HomeRecyclerViewAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.homeViewPager.adapter = promotionAdapter
        binding.landingRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.landingRecyclerView.adapter = homeRecyclerViewAdapter
        binding.homeViewPager.isUserInputEnabled = false

        viewModelPromotion.promotionEntity.observe(viewLifecycleOwner) { promotions ->
            promotionAdapter.setProlineItems(promotions)
        }
        viewModelLanding.landing.observe(viewLifecycleOwner) { landing ->
            homeRecyclerViewAdapter.items = landing
            Log.d("homeRecyclerViewAdapter", "items${homeRecyclerViewAdapter.items}")
            Log.d("landing.content", "${landing}")
        }
        return binding.root
    }
}