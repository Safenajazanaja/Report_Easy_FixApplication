package com.example.reporteasyfixapplication.presentation.backlog.adater

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SimpleRecyclerView
import com.example.reporteasyfixapplication.presentation.backlog.list.List2
import kotlinx.android.synthetic.main.item_list2_backlog.view.*

class List2Adapter : SimpleRecyclerView<List2>() {
    override fun getLayout(): Int = R.layout.item_list2_backlog

    override fun View.onBindViewHolder(currentData: List2, beforeData: List2?) {
        tvData4.text = currentData.amphur_name.toString()
        val adt= List3Adapter()
        recyclerView2.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=adt
        }
        adt.submitList(currentData.listamphur_name)

//        recyclerView.submitList(List3Adapter(),currentData.list3)

    }
}