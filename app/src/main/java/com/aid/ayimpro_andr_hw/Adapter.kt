package com.aid.ayimpro_andr_hw

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aid.ayimpro_andr_hw.databinding.RepoListBinding

class CharacterAdapter(
    private val onItemClicked: (Long) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val data = mutableListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(view, onItemClicked)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is ViewHolder -> holder.bind(data[position])
        }
    }

    override fun getItemCount(): Int = data.size

    fun setItems(it: List<Item>) {
        data.clear()
        data.addAll(it)
        notifyDataSetChanged()
    }
}

private class ViewHolder(
    view: View,
    private val onItemClicked: (Long) -> Unit
): RecyclerView.ViewHolder(view) {
    private val binding = RepoListBinding.bind(view)

    fun bind(repositories: Item) = with(binding) {
        repoName.text = repositories.name
    }
}