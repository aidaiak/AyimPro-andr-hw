package com.aid.ayimpro_andr_hw.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aid.ayimpro_andr_hw.database.CharacterEntity
import com.aid.ayimpro_andr_hw.databinding.ItemRecyclerBinding
import com.bumptech.glide.Glide


class Adapter(
    private val onItemClicked: (id:Long) -> Unit
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private var list: List<CharacterEntity> = listOf()

    fun setData(list: List<CharacterEntity>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, onItemClicked)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(
        private val binding : ItemRecyclerBinding,
        private val click: (id: Long) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(character: CharacterEntity) {
            binding.apply {
                Glide.with(itemView.context).load(character.image).into(imageView)
                nameTextView.text = character.name
                statusTextView.text = character.status
                speciesTextView.text = character.species
                locationTextView.text = character.location
            }

            itemView.setOnClickListener {
                click.invoke(character.id)
            }
        }
    }
}

