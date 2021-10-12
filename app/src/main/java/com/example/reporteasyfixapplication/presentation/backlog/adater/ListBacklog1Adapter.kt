package com.example.reporteasyfixapplication.presentation.backlog.adater

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SimpleRecyclerView
import com.example.reporteasyfixapplication.presentation.backlog.list.ListBacklog1
import kotlinx.android.synthetic.main.item_list1_backlod.view.*
import java.text.SimpleDateFormat

class ListBacklog1Adapter: SimpleRecyclerView<ListBacklog1>() {
    override fun getLayout(): Int = R.layout.item_list1_backlod

    override fun View.onBindViewHolder(currentData: ListBacklog1, beforeData: ListBacklog1?) {

        val sdf = SimpleDateFormat("dd/MM/yyyy")
        tvData3.text=currentData.date
        tvData2.text="รวม "+currentData.datesum.toString()+" งาน"
        val adt= ListBacklog2Adapter()
        recyclerView1.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=adt
        }
        adt.submitList(currentData.listprovince)

//        recyclerView.submitList(List2Adapter(),currentData.listprovince)
    }
}