package com.example.reporteasyfixapplication.presentation.materialsreport.adapter

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SimpleRecyclerView
import com.example.reporteasyfixapplication.presentation.backlog.adater.ListBacklog2Adapter
import com.example.reporteasyfixapplication.presentation.backlog.list.ListBacklog1
import com.example.reporteasyfixapplication.presentation.materialsreport.list.ListMat1
import kotlinx.android.synthetic.main.item_list1_mat.view.*

class ListMat1Adapter: SimpleRecyclerView<ListMat1>() {
    override fun getLayout(): Int =R.layout.item_list1_mat

    override fun View.onBindViewHolder(currentData: ListMat1, beforeData: ListMat1?) {
        tvData2mat.text=currentData.name_tec
        tvData3mat.text="รวมชนิดวัดสุก่อสร้าง${currentData.summat.toString()}ชนิด"
        val adt= ListMat2Adapter()
        recyclerView1mat.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=adt
        }
        adt.submitList(currentData.listMat2)
    }
}