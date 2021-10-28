package com.example.reporteasyfixapplication.presentation.summarize.adapter

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SimpleRecyclerView
import com.example.reporteasyfixapplication.presentation.backlog.adater.ListBacklog2Adapter
import com.example.reporteasyfixapplication.presentation.profit.list.Listprofit1
import com.example.reporteasyfixapplication.presentation.summarize.list.ListSum1
import kotlinx.android.synthetic.main.activity_sum.view.*
import kotlinx.android.synthetic.main.item_list1_backlod.view.*
import kotlinx.android.synthetic.main.item_list1_sum.view.*
import kotlinx.android.synthetic.main.item_list2_sum.view.*
import java.math.RoundingMode
import java.text.DecimalFormat

class ListSum1Adapter: SimpleRecyclerView<ListSum1>() {
    override fun getLayout(): Int = R.layout.item_list1_sum

    override fun View.onBindViewHolder(currentData: ListSum1, beforeData: ListSum1?) {
        val df = DecimalFormat("###,###.00")
        df.roundingMode = RoundingMode.CEILING
        tvData3sum.text=currentData.date
//        tvData2sum.text="รวมทั้งสิ้น${currentData.sumcompleted+currentData.sumwait} งาน"

        tvData4sum.text=currentData.sumjob.toString()
        tvData5sum.text=currentData.sumwait.toString()
        tvData6sum.text=currentData.sumcomple.toString()

//        val adt= ListSum2Adapter()
//        recyclerView1sum.apply {
//            layoutManager= LinearLayoutManager(context)
//            adapter=adt
//        }
//        adt.submitList(currentData.listsum2)
    }
}