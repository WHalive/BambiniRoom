package com.example.bambini.homeRecyclerView

import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import coil.load
import com.example.bambini.databinding.BannerItemViewBinding
import com.example.bambini.databinding.FeaturedItemViewBinding
import com.example.bambini.databinding.QuadroItemViewBinding
import com.example.bambini.entity.BannerEntity
import com.example.bambini.entity.FeaturedCategories
import com.example.bambini.entity.QuadroWithCategories

sealed class HomeRecyclerViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class BannerViewHolder(private val binding: BannerItemViewBinding) :
        HomeRecyclerViewHolder(binding) {
        fun bind(bannerImage: BannerEntity) {
            binding.bannerImage.load(bannerImage.image.src)
        }
    }

    class FeaturedViewHolder(private val binding: FeaturedItemViewBinding) :
        HomeRecyclerViewHolder(binding) {
        fun bind(
            featuredImage: FeaturedCategories
        ) {
            binding.featuredImage0.load(featuredImage.featuredCategories[0].image.src)
            binding.featuredImage0Text.text = featuredImage.featuredCategories[0].title
            binding.featuredImage1.load(featuredImage.featuredCategories[1].image.src)
            binding.featuredImage1Text.text = featuredImage.featuredCategories[1].title
            binding.featuredImage2.load(featuredImage.featuredCategories[2].image.src)
            binding.featuredImage2Text.text = featuredImage.featuredCategories[2].title
            binding.featuredImage3.load(featuredImage.featuredCategories[3].image.src)
            binding.featuredImage3Text.text = featuredImage.featuredCategories[3].title

        }
    }

    class QuadroViewHolder(private val binding: QuadroItemViewBinding) :
        HomeRecyclerViewHolder(binding) {
        fun bind(
            quadroItem: QuadroWithCategories

        ) {
            binding.mainQuadroImage.load(quadroItem.quadro.image.src)
            binding.quadroTitle.text = quadroItem.quadro.title
            binding.quadroImage0.setBackgroundColor(quadroItem.quadroItems[0].backgroundColor.toColorInt())
            binding.quadroImage0.load(quadroItem.quadroItems[0].image.src)
            binding.quadroImage0Text.text = quadroItem.quadroItems[0].title
            binding.quadroImage1.setBackgroundColor(quadroItem.quadroItems[1].backgroundColor.toColorInt())
            binding.quadroImage1.load(quadroItem.quadroItems[1].image.src)
            binding.quadroImage1Text.text = quadroItem.quadroItems[1].title
            binding.quadroImage2.setBackgroundColor(quadroItem.quadroItems[2].backgroundColor.toColorInt())
            binding.quadroImage2.load(quadroItem.quadroItems[2].image.src)
            binding.quadroImage2Text.text = quadroItem.quadroItems[2].title
            binding.quadroImage3.setBackgroundColor(quadroItem.quadroItems[3].backgroundColor.toColorInt())
            binding.quadroImage3.load(quadroItem.quadroItems[3].image.src)
            binding.quadroImage3Text.text = quadroItem.quadroItems[3].title

        }
    }
}
