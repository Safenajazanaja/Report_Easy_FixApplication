package com.example.reporteasyfixapplication.presentation.summarize.adapter

import android.view.View
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SimpleRecyclerView
import com.example.reporteasyfixapplication.presentation.summarize.list.ListSum2
import kotlinx.android.synthetic.main.item_list1_sum.view.*
import kotlinx.android.synthetic.main.item_list1_sum.view.tvData3sum
import kotlinx.android.synthetic.main.item_list2_sum.view.*

class ListSum2Adapter : SimpleRecyclerView<ListSum2>(){
    override fun getLayout(): Int = R.layout.item_list2_sum

    override fun View.onBindViewHolder(currentData: ListSum2, beforeData: ListSum2?) {
        tvData4sum.text=currentData.sumjob.toString()
        tvData5sum.text=currentData.sumwait.toString()
        tvData6sum.text=currentData.sumcomple.toString()
    }
}