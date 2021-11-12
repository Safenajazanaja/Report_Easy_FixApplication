package com.example.reporteasyfixapplication.presentation.call.adapter

import android.view.View
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SimpleRecyclerView
import com.example.reporteasyfixapplication.presentation.call.list.ListId2
import com.example.reporteasyfixapplication.presentation.call.list.ListMater
import kotlinx.android.synthetic.main.item_list3_call.view.*

class ListCall3Adapter: SimpleRecyclerView<ListMater>() {
    override fun getLayout(): Int = R.layout.item_list3_call

    override fun View.onBindViewHolder(currentData: ListMater, beforeData: ListMater?) {
        tvData14call.text=currentData.matername
    }
}