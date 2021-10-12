package com.example.reporteasyfixapplication.presentation.backlog.adater

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SimpleRecyclerView
import com.example.reporteasyfixapplication.presentation.backlog.list.ListBacklog2
import kotlinx.android.synthetic.main.item_list2_backlog.view.*

class ListBacklog2Adapter : SimpleRecyclerView<ListBacklog2>() {
    override fun getLayout(): Int = R.layout.item_list2_backlog

    override fun View.onBindViewHolder(currentData: ListBacklog2, beforeData: ListBacklog2?) {
        tvData4.text = currentData.province.toString()
        tvData5.text = currentData.type.toString()
        tvData6.text = currentData.home.toString()
        tvData7.text = currentData.repairlist.toString()
//        val adt= ListBacklog3Adapter()
//        recyclerView2.apply {
//            layoutManager=LinearLayoutManager(context)
//            adapter=adt
//        }
//        adt.submitList(currentData.listprovince)

//        recyclerView.submitList(List3Adapter(),currentData.list3)

    }
}