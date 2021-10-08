package com.example.reporteasyfixapplication.presentation.backlog.adater

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SimpleRecyclerView
import com.example.reporteasyfixapplication.presentation.backlog.list.ListBacklog5
import kotlinx.android.synthetic.main.item_list5_backlog.view.*

class ListBacklog5Adapter: SimpleRecyclerView<ListBacklog5>() {
    override fun getLayout(): Int = R.layout.item_list5_backlog


    override fun View.onBindViewHolder(currentData: ListBacklog5, beforeData: ListBacklog5?) {
        tvData7.text = currentData.date
        if (currentData.date==beforeData?.date){
//            tvData7.text="  "
        }
        val adt= ListBacklog6Adapter()
        recyclerView5.apply {
            layoutManager= LinearLayoutManager(context)
            adapter=adt
        }
        adt.submitList(currentData.listhome)
    }
}