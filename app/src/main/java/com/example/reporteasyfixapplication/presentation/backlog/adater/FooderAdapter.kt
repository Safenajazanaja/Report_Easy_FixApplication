package com.example.reporteasyfixapplication.presentation.backlog.adater

import android.view.View
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SingleRecyclerView
import com.example.reporteasyfixapplication.presentation.backlog.list.Fooder
import kotlinx.android.synthetic.main.item_footer_backlog.view.*


class FooderAdapter: SingleRecyclerView<Fooder>() {
    override fun getLayout(): Int = R.layout.item_footer_backlog
    override fun View.onBindViewHolder(data: Fooder?) {
        tvData1.text="รวม${data?.data1}งาน"

    }


}