package com.example.reporteasyfixapplication.presentation.completejob.adapter

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SimpleRecyclerView
import com.example.reporteasyfixapplication.SingleRecyclerView
import com.example.reporteasyfixapplication.presentation.completejob.list.ListCom1
import com.example.reporteasyfixapplication.presentation.materialsreport.list.ListMat1
import kotlinx.android.synthetic.main.item_list1_complete.view.*


class ListComplete1Adapter: SimpleRecyclerView<ListCom1>() {
    override fun getLayout(): Int =R.layout.item_list1_complete

    override fun View.onBindViewHolder(currentData: ListCom1, beforeData: ListCom1?) {
        tvData3com.text=currentData.date
        tvData2com.text="รวม${currentData.datesum.toString()}งาน"
        val adt=ListComplete2Adapter()
        recyclerView1com.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=adt
        }
        adt.submitList(currentData.listtec)
    }


}