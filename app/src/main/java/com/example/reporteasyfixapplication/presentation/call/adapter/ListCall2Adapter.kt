package com.example.reporteasyfixapplication.presentation.call.adapter

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SimpleRecyclerView
import com.example.reporteasyfixapplication.presentation.call.list.ListId2
import kotlinx.android.synthetic.main.item_list1_call.view.*
import kotlinx.android.synthetic.main.item_list2_call.view.*

class ListCall2Adapter: SimpleRecyclerView<ListId2>()  {
    override fun getLayout(): Int = R.layout.item_list2_call

    override fun View.onBindViewHolder(currentData: ListId2, beforeData: ListId2?) {
        tvData8call.text=currentData.userid.toString()
        tvData9call.text=currentData.name
        tvData10call.text=currentData.idjob
        tvData11call.text=currentData.dateexpect
        tvData12call.text=currentData.stats
        if (currentData.dateend==null){
            tvData13call.text="-"
        }else{
            tvData13call.text=currentData.dateend
        }

        val adt= ListCall3Adapter()
        recyclerView2call.apply {
            layoutManager= LinearLayoutManager(context)
            adapter=adt
        }
        adt.submitList(currentData.listmater)

    }
}