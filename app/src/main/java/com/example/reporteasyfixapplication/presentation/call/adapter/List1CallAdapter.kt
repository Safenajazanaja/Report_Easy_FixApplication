package com.example.reporteasyfixapplication.presentation.call.adapter

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SimpleRecyclerView
import com.example.reporteasyfixapplication.presentation.backlog.adater.ListBacklog2Adapter
import com.example.reporteasyfixapplication.presentation.backlog.list.ListBacklog1
import com.example.reporteasyfixapplication.presentation.call.list.ListDate1
import kotlinx.android.synthetic.main.item_list1_call.view.*

class List1CallAdapter: SimpleRecyclerView<ListDate1>() {
    override fun getLayout(): Int = R.layout.item_list1_call

    override fun View.onBindViewHolder(currentData: ListDate1, beforeData: ListDate1?) {
        tvData7call.text=currentData.datestart
        tvData4call.text=currentData.sumuserdate.toString()
        tvData5call.text=currentData.sumjobcompleteddate.toString()
        tvData6call.text=currentData.sumnotdate.toString()
        val adt= ListCall2Adapter()
        recyclerView1call.apply {
                layoutManager= LinearLayoutManager(context)
                adapter=adt
            }
        adt.submitList(currentData.listid)

    }
}