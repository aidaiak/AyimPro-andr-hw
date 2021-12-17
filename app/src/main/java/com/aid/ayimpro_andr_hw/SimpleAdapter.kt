package com.aid.ayimpro_andr_hw

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SimpleAdapter : RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {

    private var list = listOf<String>()
    private var imgUrls = listOf<String>()

    fun setData(list: List<String>) {
        this.list = list
    }

    fun setImage(imgUrls: List<String>) {
        this.imgUrls = imgUrls
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SimpleAdapter.ViewHolder, position: Int) {
        holder.txt.text = list[position]
        val url = if (position % 2 == 0) {
            imgUrls[0]
        } else {
            imgUrls[1]
        }
        Glide.with(holder.itemView.context)
            .load(url)
            .override(60, 60)
            .into(holder.img)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {
        val txt = itemView.findViewById<AppCompatTextView>(R.id.txt)
        val img = itemView.findViewById<AppCompatImageView>(R.id.img)
    }

}