package com.example.reporteasyfixapplication.presentation.test.adapter

import android.view.View
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SingleRecyclerView

class ColumAdapter : SingleRecyclerView<Unit>() {
    override fun getLayout(): Int = R.layout.item_colum_test
    override fun View.onBindViewHolder(data: Unit?) {
    }
}