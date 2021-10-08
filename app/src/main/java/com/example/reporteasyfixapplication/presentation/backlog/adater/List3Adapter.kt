package com.example.reporteasyfixapplication.presentation.backlog.adater

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SimpleRecyclerView
import com.example.reporteasyfixapplication.presentation.backlog.list.List3
import kotlinx.android.synthetic.main.item_list3_backlog.view.*

class List3Adapter: SimpleRecyclerView<List3>() {
    override fun getLayout(): Int = R.layout.item_list3_backlog


    override fun View.onBindViewHolder(currentData: List3, beforeData: List3?) {
        tvData5.text = currentData.district_name
        val adt= List4Adapter()
        recyclerView3.apply {
            layoutManager= LinearLayoutManager(context)
            adapter=adt
        }
        adt.submitList(currentData.listdistrict_name)
    }
}