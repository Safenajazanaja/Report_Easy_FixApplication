package com.example.reporteasyfixapplication.presentation.backlog.adater

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SimpleRecyclerView
import com.example.reporteasyfixapplication.presentation.backlog.list.List4
import kotlinx.android.synthetic.main.item_list4_backlog.view.*

class List4Adapter: SimpleRecyclerView<List4>() {
    override fun getLayout(): Int = R.layout.item_list4_backlog


    override fun View.onBindViewHolder(currentData: List4, beforeData: List4?) {
        tvData6.text = currentData.typejob
        val adt= List5Adapter()
        recyclerView4.apply {
            layoutManager= LinearLayoutManager(context)
            adapter=adt
        }
        adt.submitList(currentData.listdate)
    }
}