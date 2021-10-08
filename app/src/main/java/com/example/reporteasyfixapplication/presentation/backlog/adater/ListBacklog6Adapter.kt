package com.example.reporteasyfixapplication.presentation.backlog.adater

import android.view.View
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SimpleRecyclerView
import com.example.reporteasyfixapplication.presentation.backlog.list.ListBacklog6
import kotlinx.android.synthetic.main.item_list6_backlog.view.*

class ListBacklog6Adapter: SimpleRecyclerView<ListBacklog6>() {
    override fun getLayout(): Int = R.layout.item_list6_backlog
    override fun View.onBindViewHolder(currentData: ListBacklog6, beforeData: ListBacklog6?) {
        tvData8.text=currentData.home
        tvData9.text= currentData.repairlist

    }
}