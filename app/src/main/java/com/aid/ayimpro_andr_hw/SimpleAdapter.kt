package com.aid.ayimpro_andr_hw

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class SimpleAdapter : RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {
    private var list = listOf<String>()

    fun setData(list: List<String>) {
        this.list = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SimpleAdapter.ViewHolder, position: Int) {
        val item = list[position]
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