package com.example.reporteasyfixapplication.presentation.materialsreport.adapter

import android.view.View
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SimpleRecyclerView
import com.example.reporteasyfixapplication.presentation.materialsreport.list.ListMat2
import kotlinx.android.synthetic.main.item_list2_mat.view.*

class ListMat2Adapter: SimpleRecyclerView<ListMat2>() {
    override fun getLayout(): Int =R.layout.item_list2_mat

    override fun View.onBindViewHolder(currentData: ListMat2, beforeData: ListMat2?) {
        tvData4mat.text=currentData.mater_name
        tvData5mat.text=currentData.mater_qty.toString()
    }
}