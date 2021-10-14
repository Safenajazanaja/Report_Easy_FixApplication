package com.example.reporteasyfixapplication.presentation.completejob.adapter

import android.view.View
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.base.SingleRecyclerView
import com.example.reporteasyfixapplication.presentation.completejob.list.FooderCom
import kotlinx.android.synthetic.main.item_fooder_complete.view.*

class FooderCompleteAdapter: SingleRecyclerView<FooderCom>() {
    override fun getLayout(): Int =R.layout.item_fooder_complete
    override fun View.onBindViewHolder(data: FooderCom?) {
        tvData1com.text="รวมทั้งหมด${data?.sum}งาน"
    }

}