package com.example.reporteasyfixapplication.presentation.materialsreport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.base.BaseActivity
import com.example.reporteasyfixapplication.data.request.ReportbacklogRequest
import com.example.reporteasyfixapplication.presentation.materialsreport.adapter.ColumMatAdapter
import com.example.reporteasyfixapplication.presentation.materialsreport.adapter.FooderMatAdapter
import com.example.reporteasyfixapplication.presentation.materialsreport.adapter.ListMat1Adapter
import kotlinx.android.synthetic.main.activity_materialst.*
import kotlinx.android.synthetic.main.item_list1_mat.*
import kotlinx.android.synthetic.main.item_list1_mat.recyclerView1mat

class MaterialstActivity :  AppCompatActivity() {

    private val mfoodAdapter = FooderMatAdapter()
    private val mList1 = ListMat1Adapter()
    private val mColumAdapter = ColumMatAdapter()
    private lateinit var viewModel:MaterialstViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materialst)
        viewModel = ViewModelProvider(this).get(MaterialstViewModel::class.java)
        viewModel.report(
            request = ReportbacklogRequest(
                star = 1614786427043,
                end =1629365435441
            )
        )
        val adt = ConcatAdapter(
            mColumAdapter, mList1, mfoodAdapter
        )
        recylerViewmat.apply {
            layoutManager = LinearLayoutManager(baseContext)
            adapter = adt
        }
        viewModel.report.observe(this,{
            mColumAdapter.submitData(Unit)
            mList1.submitList(it.listnametec)
            mfoodAdapter.submitData(it)
        })
    }
}