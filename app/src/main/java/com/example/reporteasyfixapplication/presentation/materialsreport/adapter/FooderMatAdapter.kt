package com.example.reporteasyfixapplication.presentation.materialsreport.adapter

import android.view.View
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SingleRecyclerView
import com.example.reporteasyfixapplication.presentation.materialsreport.list.FooderMat
import kotlinx.android.synthetic.main.item_fooder_materialst.view.*

class FooderMatAdapter:SingleRecyclerView<FooderMat>() {
    override fun getLayout(): Int = R.layout.item_fooder_materialst
    override fun View.onBindViewHolder(data: FooderMat?) {
        tvData1mat.text="รวมชนิดวัสดุก่อสร้าง${data?.sum}ชนิด"
    }
}