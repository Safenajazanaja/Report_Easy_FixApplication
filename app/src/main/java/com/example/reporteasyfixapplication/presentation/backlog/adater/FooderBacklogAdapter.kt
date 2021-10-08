package com.example.reporteasyfixapplication.presentation.backlog.adater

import android.view.View
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SingleRecyclerView
import com.example.reporteasyfixapplication.presentation.backlog.list.FooderBacklog
import kotlinx.android.synthetic.main.item_footer_backlog.view.*


class FooderBacklogAdapter: SingleRecyclerView<FooderBacklog>() {
    override fun getLayout(): Int = R.layout.item_footer_backlog
    override fun View.onBindViewHolder(data: FooderBacklog?) {
        tvData1.text="รวมทั้งหมด${data?.sum}งาน"

    }


}