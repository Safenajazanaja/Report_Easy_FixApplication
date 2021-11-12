package com.example.reporteasyfixapplication.presentation.call.adapter

import android.view.View
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SingleRecyclerView
import com.example.reporteasyfixapplication.presentation.backlog.list.FooderBacklog
import com.example.reporteasyfixapplication.presentation.call.list.FooderCall
import kotlinx.android.synthetic.main.item_fooder_call.view.*

class FooderCallAdapter: SingleRecyclerView<FooderCall>() {
    override fun getLayout(): Int = R.layout.item_fooder_call

    override fun View.onBindViewHolder(data: FooderCall?) {

        if (data?.sumuser ==null){
            tvData1call.text="-"
        }else{
            tvData1call.text= data?.sumuser.toString()
        }

        if (data?.sumjobcompleted==null){
            tvData2call.text="-"
        }else{
            tvData2call.text=data?.sumjobcompleted.toString()
        }
        if (data?.sumnot==null){
            tvData3call.text="-"
        }else{
            tvData3call.text=data?.sumnot.toString()
        }


    }
}