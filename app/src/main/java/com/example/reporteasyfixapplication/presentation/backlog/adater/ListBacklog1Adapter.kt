package com.example.reporteasyfixapplication.presentation.backlog.adater

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SimpleRecyclerView
import com.example.reporteasyfixapplication.presentation.backlog.list.ListBacklog1
import kotlinx.android.synthetic.main.item_list1_backlod.view.*

class ListBacklog1Adapter: SimpleRecyclerView<ListBacklog1>() {
    override fun getLayout(): Int = R.layout.item_list1_backlod

    override fun View.onBindViewHolder(currentData: ListBacklog1, beforeData: ListBacklog1?) {
        tvData3.text=currentData.province
        tvData2.text="รวม "+currentData.provincesum.toString()+" งาน"
        val adt= ListBacklog2Adapter()
        recyclerView1.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=adt
        }
        adt.submitList(currentData.listamphur_name)
//
//        recyclerView.submitList(List2Adapter(),currentData.list2)
    }
}