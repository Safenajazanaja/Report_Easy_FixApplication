package com.example.reporteasyfixapplication.presentation.summarize.adapter

import android.view.View
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SingleRecyclerView
import com.example.reporteasyfixapplication.presentation.summarize.list.FooderSum
import kotlinx.android.synthetic.main.item_fooder_sum.view.*

class FooderSumAdapter : SingleRecyclerView<FooderSum>() {
    override fun getLayout(): Int = R.layout.item_fooder_sum

    override fun View.onBindViewHolder(data: FooderSum?) {
        val int = data?.sumcompleted?.plus(data?.sumwait!!)
        tvData1foodersum.text = "รวมทั้งสิน"+int.toString()+"งาน"
        tvData2foodersum.text = "รวมทั้งสิน"+data?.sumwait.toString()+"งาน"
        tvData3foodersum.text = "รวมทั้งสิน"+data?.sumcompleted.toString()+"งาน"
    }
}