package com.aid.ayimpro_andr_hw

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler = findViewById<RecyclerView>(R.id.recycler)
        val layoutManager = GridLayoutManager(this, 2)
        val adapter = SimpleAdapter()

        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
        recycler.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))

        val list = mutableListOf<String>()
        for (i in 0..20) {
            list.add("ITEM - $i")
        }

        adapter.setData(list)
    }
}