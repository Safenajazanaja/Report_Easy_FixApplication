package com.example.reporteasyfixapplication.presentation.backlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.data.request.ReportbacklogRequest
import com.example.reporteasyfixapplication.presentation.backlog.adater.ColumAdapter
import com.example.reporteasyfixapplication.presentation.backlog.adater.FooderAdapter
import com.example.reporteasyfixapplication.presentation.backlog.adater.List1Adapter
import com.example.reporteasyfixapplication.presentation.backlog.list.Fooder
import kotlinx.android.synthetic.main.activity_backlog.*
import kotlinx.coroutines.awaitAll

class BacklogActivity : AppCompatActivity() {
    private val mfoodAdapter = FooderAdapter()
    private val mList1 = List1Adapter()
    private val mColumAdapter = ColumAdapter()
    private lateinit var viewModel:BacklogViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_backlog)
        viewModel = ViewModelProvider(this).get(BacklogViewModel::class.java)
        val adt = ConcatAdapter(
                mColumAdapter, mList1, mfoodAdapter
        )
        recylerView.apply {
            layoutManager = LinearLayoutManager(baseContext)

            adapter = adt
        }


        mColumAdapter.submitData(Unit)
//        mList1.submitList(viewModel.report.value)




        viewModel.report.observe(this,{
            mfoodAdapter.submitData(it)
            mList1.submitList(it.list1)
        })
        viewModel.report(
                request = ReportbacklogRequest(
                        star = 1614786427043,
                        end =1629365435441
                )
        )
    }
}