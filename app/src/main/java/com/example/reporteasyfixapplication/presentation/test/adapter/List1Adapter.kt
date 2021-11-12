package com.example.reporteasyfixapplication.presentation.test.adapter

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.SimpleRecyclerView
import com.example.reporteasyfixapplication.presentation.materialsreport.adapter.ListMat2Adapter
import com.example.reporteasyfixapplication.presentation.materialsreport.list.ListMat1
import com.example.reporteasyfixapplication.presentation.test.list.Listtest1
import kotlinx.android.synthetic.main.item_list1_mat.view.*
import kotlinx.android.synthetic.main.item_list1_test.view.*

class List1Adapter : SimpleRecyclerView<Listtest1>() {
    override fun getLayout(): Int = R.layout.item_list1_test

    override fun View.onBindViewHolder(currentData: Listtest1, beforeData: Listtest1?) {
        tvData2test.text = currentData.matername
        tvData3test.text = "รวม${currentData.summat.toString()}หน่วย"
        val adt = List2Adapter()
        recyclerView1test.apply {
            layoutManager= LinearLayoutManager(context)
            adapter=adt
        }
        adt.submitList(currentData.listMat2)
    }
}