package com.example.reporteasyfixapplication.presentation.profit.adapter

import android.view.View
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SingleRecyclerView
import com.example.reporteasyfixapplication.presentation.materialsreport.list.FooderMat
import com.example.reporteasyfixapplication.presentation.profit.list.Fooderprofit
import kotlinx.android.synthetic.main.item_fooder_profit.view.*
import java.math.RoundingMode
import java.text.DecimalFormat

class FooderProfitAdapter: SingleRecyclerView<Fooderprofit>() {
    override fun getLayout(): Int = R.layout.item_fooder_profit

    override fun View.onBindViewHolder(data: Fooderprofit?) {
        val df = DecimalFormat("###,###.00")
        df.roundingMode = RoundingMode.CEILING
        tvData1profit.text="รวมค่าแรง${df.format(data?.sumtec)}บาท"
    }
}