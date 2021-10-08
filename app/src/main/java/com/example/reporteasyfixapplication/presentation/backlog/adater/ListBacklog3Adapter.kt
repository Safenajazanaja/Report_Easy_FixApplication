package com.example.reporteasyfixapplication.presentation.backlog.adater

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SimpleRecyclerView
import com.example.reporteasyfixapplication.presentation.backlog.list.ListBacklog3
import kotlinx.android.synthetic.main.item_list3_backlog.view.*

class ListBacklog3Adapter: SimpleRecyclerView<ListBacklog3>() {
    override fun getLayout(): Int = R.layout.item_list3_backlog


    override fun View.onBindViewHolder(currentData: ListBacklog3, beforeData: ListBacklog3?) {
        tvData5.text = currentData.district_name
        val adt= ListBacklog4Adapter()
        recyclerView3.apply {
            layoutManager= LinearLayoutManager(context)
            adapter=adt
        }
        adt.submitList(currentData.listdistrict_name)
    }
}