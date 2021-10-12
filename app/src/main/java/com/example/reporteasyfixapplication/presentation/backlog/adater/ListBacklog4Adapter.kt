package com.example.reporteasyfixapplication.presentation.backlog.adater

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SimpleRecyclerView
import com.example.reporteasyfixapplication.presentation.backlog.list.ListBacklog4
import kotlinx.android.synthetic.main.item_list4_backlog.view.*
import java.text.SimpleDateFormat


class ListBacklog4Adapter: SimpleRecyclerView<ListBacklog4>() {
    override fun getLayout(): Int = R.layout.item_list4_backlog


    override fun View.onBindViewHolder(currentData: ListBacklog4, beforeData: ListBacklog4?) {
//        val sdf = SimpleDateFormat("dd/MM/yyyy")
//        tvData6.text = sdf.format(currentData.date)
//        tvData7.text = currentData.type
//        tvData8.text=currentData.home
//        tvData9.text= currentData.repairlist
//        if (beforeData?.date !=null){
//            val v1=sdf.format(currentData.date)
//            val v2=sdf.format(beforeData?.date)
//            if (v1 ==v2){
//                tvData6.text=" "
////                if (currentData.type == beforeData?.type){
////                    tvData7.text = " "
////                }
//            }
//        }






//        val adt= ListBacklog5Adapter()
//        recyclerView4.apply {
//            layoutManager= LinearLayoutManager(context)
//            adapter=adt
//        }
//        adt.submitList(currentData.listdate)
    }
}