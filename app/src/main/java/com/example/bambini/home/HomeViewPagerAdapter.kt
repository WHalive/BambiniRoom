package com.example.bambinifashion.home

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.toColorInt
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.bambini.R
import com.example.bambinifashion.database.PromotionEntity

class HomeViewPagerAdapter : RecyclerView.Adapter<HomeViewPagerAdapter.ViewPagerViewHolder>() {

    private val items: MutableList<PromotionEntity> = mutableListOf()

    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.proline_item_view, parent, false)
        return ViewPagerViewHolder(view)
    }


    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val currentTitle = items[position]
        holder.itemView.findViewById<TextView>(R.id.proline_text).text =
            HtmlCompat.fromHtml(currentTitle.content, HtmlCompat.FROM_HTML_MODE_COMPACT)
        currentTitle.highlight?.textColor?.let {
            holder.itemView.findViewById<TextView>(R.id.proline_text).setTextColor(
                it.toColorInt()
            )
        }
        holder.itemView.findViewById<ConstraintLayout>(R.id.constraint)
            .setBackgroundColor(if (currentTitle.highlight != null) (currentTitle.highlight!!.backgroundColor.toColorInt()) else (R.color.white))

        holder.itemView.findViewById<ConstraintLayout>(R.id.constraint)
            .setBackgroundColor(R.color.black)
        currentTitle.highlight?.backgroundColor?.let {
            holder.itemView.findViewById<ConstraintLayout>(R.id.constraint).setBackgroundColor(
                it.toColorInt()
            )
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setProlineItems(prolines: List<PromotionEntity>) {
        items.clear()
        items.addAll(prolines)
        Log.d("ddk9499", "setProlineItems: ${items.size}")
        this.notifyDataSetChanged()
    }
}