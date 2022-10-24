package com.example.bambini.homeRecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bambini.R
import com.example.bambini.databinding.BannerItemViewBinding
import com.example.bambini.databinding.FeaturedItemViewBinding
import com.example.bambini.databinding.QuadroItemViewBinding
import com.example.bambini.entity.BannerEntity
import com.example.bambini.entity.FeaturedCategories
import com.example.bambini.entity.LandingEntity
import com.example.bambini.entity.QuadroWithCategories

class HomeRecyclerViewAdapter : RecyclerView.Adapter<HomeRecyclerViewHolder>() {

    var items = listOf<LandingEntity>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerViewHolder {
        return when (viewType) {
            R.layout.banner_item_view -> HomeRecyclerViewHolder.BannerViewHolder(
                BannerItemViewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            R.layout.featured_item_view -> HomeRecyclerViewHolder.FeaturedViewHolder(
                FeaturedItemViewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            R.layout.quadro_item_view -> HomeRecyclerViewHolder.QuadroViewHolder(
                QuadroItemViewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException(" Invalid ViewType Provided")
        }
    }

    override fun onBindViewHolder(holder: HomeRecyclerViewHolder, position: Int) {

        when (holder) {
            is HomeRecyclerViewHolder.BannerViewHolder -> holder.bind(items[position] as BannerEntity)
            is HomeRecyclerViewHolder.FeaturedViewHolder -> holder.bind(items[position] as FeaturedCategories)
            is HomeRecyclerViewHolder.QuadroViewHolder -> holder.bind(items[position] as QuadroWithCategories)
        }
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is BannerEntity -> R.layout.banner_item_view
            is FeaturedCategories -> R.layout.featured_item_view
            is QuadroWithCategories -> R.layout.quadro_item_view
            else -> throw IllegalStateException()
        }
    }
}