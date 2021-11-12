package com.example.reporteasyfixapplication.presentation.test.adapter

import android.view.View
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SimpleRecyclerView
import com.example.reporteasyfixapplication.presentation.test.list.Listtest1
import com.example.reporteasyfixapplication.presentation.test.list.Listtest2
import kotlinx.android.synthetic.main.item_list2_mat.view.*
import kotlinx.android.synthetic.main.item_list2_test.view.*

class List2Adapter: SimpleRecyclerView<Listtest2>() {
    override fun getLayout(): Int = R.layout.item_list2_test

    override fun View.onBindViewHolder(currentData: Listtest2, beforeData: Listtest2?) {
        tvData4test.text=currentData.mater_date
        tvData5test.text=currentData.mater_qty.toString()
    }
}