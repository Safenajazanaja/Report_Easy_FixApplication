package com.example.reporteasyfixapplication.presentation.completejob.adapter

import android.view.View
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SimpleRecyclerView
import com.example.reporteasyfixapplication.presentation.completejob.list.ListCom2
import kotlinx.android.synthetic.main.item_list1_complete.view.*
import kotlinx.android.synthetic.main.item_list2_complete.view.*

class ListComplete2Adapter:SimpleRecyclerView<ListCom2>() {
    override fun getLayout(): Int = R.layout.item_list2_complete

    override fun View.onBindViewHolder(currentData: ListCom2, beforeData: ListCom2?) {
        tvData4com.text=currentData.nametec
        tvData5com.text=currentData.type
        tvData6com.text=currentData.dateend
    }
}