package com.example.reporteasyfixapplication.presentation.profit.adapter

import android.view.View
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SimpleRecyclerView
import com.example.reporteasyfixapplication.presentation.profit.list.Listprofit1
import kotlinx.android.synthetic.main.item_fooder_profit.view.*
import kotlinx.android.synthetic.main.item_list1_profit.view.*
import java.math.RoundingMode
import java.text.DecimalFormat


class ListProfit1Adapter: SimpleRecyclerView<Listprofit1>() {
    override fun getLayout(): Int = R.layout.item_list1_profit

    override fun View.onBindViewHolder(currentData: Listprofit1, beforeData: Listprofit1?) {
        val df = DecimalFormat("###,###.00")
        df.roundingMode = RoundingMode.CEILING
        tvData2profit.text=currentData.name_tec
        tvData3profit.text=currentData.sumjob.toString()
        tvData4profit.text=df.format(currentData.sumprofit).toString()+"บาท"

    }
}