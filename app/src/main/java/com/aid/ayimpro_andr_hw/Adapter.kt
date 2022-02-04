package com.aid.ayimpro_andr_hw

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.aid.ayimpro_andr_hw.database.Employee

class Adapter (private val click: (item: Employee) -> Unit) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    private var list = listOf<Employee>()

    fun setData(list: List<Employee>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.employee_recycler_item, parent, false)
        return ViewHolder(itemView, click)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(
        itemView: View,
        private val click: (item: Employee) -> Unit
    ) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(item: Employee) {
            val txtN = itemView.findViewById<AppCompatTextView>(R.id.item_name)
            val itemBtn = itemView.findViewById<AppCompatButton>(R.id.item_btn)

            txtN.text = item.name

            itemBtn.setOnClickListener {
                click.invoke(item)
            }
        }
    }
}