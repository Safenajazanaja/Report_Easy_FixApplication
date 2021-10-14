package com.example.reporteasyfixapplication.presentation.materialsreport

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.base.BaseActivity
import com.example.reporteasyfixapplication.data.request.ReportbacklogRequest
import com.example.reporteasyfixapplication.presentation.materialsreport.adapter.ColumMatAdapter
import com.example.reporteasyfixapplication.presentation.materialsreport.adapter.FooderMatAdapter
import com.example.reporteasyfixapplication.presentation.materialsreport.adapter.ListMat1Adapter
import kotlinx.android.synthetic.main.activity_backlog.*
import kotlinx.android.synthetic.main.activity_backlog.totext
import kotlinx.android.synthetic.main.activity_complete.*
import kotlinx.android.synthetic.main.activity_materialst.*
import kotlinx.android.synthetic.main.item_list1_mat.*
import kotlinx.android.synthetic.main.item_list1_mat.recyclerView1mat
import java.util.*

class MaterialstActivity :  AppCompatActivity() {
    private var mCalendarstar: Calendar? = null
    private var mCalendarend: Calendar? = null
    var dateinmax: Long? = null
    private val mfoodAdapter = FooderMatAdapter()
    private val mList1 = ListMat1Adapter()
    private val mColumAdapter = ColumMatAdapter()
    private lateinit var viewModel:MaterialstViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materialst)
        viewModel = ViewModelProvider(this).get(MaterialstViewModel::class.java)
//        viewModel.report(
//            request = ReportbacklogRequest(
//                star = 1614786427043,
//                end =1634066475223
//            )
//        )
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


        bt_dete_startmat.setOnClickListener {
            val calendar = mCalendarstar ?: Calendar.getInstance()

            val year = calendar[Calendar.YEAR]
            val month = calendar[Calendar.MONTH]
            val day = calendar[Calendar.DAY_OF_MONTH]

            calendar.add(Calendar.DATE, 0)
            val dateDialog = DatePickerDialog(
                this,
                { view, year, month, dayOfMonth ->
//                        Toast.makeText(
//                                baseContext,
//                                "$year/${month.plus(1)}/$dayOfMonth",
//                                Toast.LENGTH_SHORT
//                        ).show()
                    bt_dete_startmat.setText("$dayOfMonth/${month.plus(1)}/$year")
                    bt_dete_endmat.visibility = View.VISIBLE

                    totextmat.visibility = View.VISIBLE


                    val calendar = Calendar.getInstance().apply {
                        set(year, month, dayOfMonth)

                    }
                    mCalendarstar = calendar
                    dateinmax = calendar.timeInMillis

                },
                year,
                month,
                day,
            )

            calendar.add(Calendar.DATE, 0)
//            dateDialog.datePicker.maxDate = DateTime.now().millis

//                .show()
            dateDialog.show()


        }

        bt_dete_endmat.setOnClickListener {
            val calendar = mCalendarend ?: Calendar.getInstance()

            val year = calendar[Calendar.YEAR]
            val month = calendar[Calendar.MONTH]
            val day = calendar[Calendar.DAY_OF_MONTH]

            calendar.add(Calendar.DATE, 0)
            val dateDialog = DatePickerDialog(
                this,
                { view, year, month, dayOfMonth ->
//                        Toast.makeText(
//                                baseContext,
//                                "$year/${month.plus(1)}/$dayOfMonth",
//                                Toast.LENGTH_SHORT
//                        ).show()
                    bt_dete_endmat.setText("$dayOfMonth/${month.plus(1)}/$year")
                    bt_okmat.visibility = View.VISIBLE
                    bt_okmat.isEnabled=true
                    totextmat.visibility=View.VISIBLE


                    val calendar = Calendar.getInstance().apply {
                        set(year, month, dayOfMonth)
                    }
                    mCalendarend = calendar

                },
                year,
                month,
                day,
            )

            calendar.add(Calendar.DATE, 0)
//            dateDialog.datePicker.maxDate = DateTime.now().millis
            dateDialog.datePicker.minDate = dateinmax!!

//                .show()
            dateDialog.show()
        }

        bt_okmat.setOnClickListener {
            val date1 = mCalendarstar!!.timeInMillis
            val date2 = mCalendarend!!.timeInMillis
            viewModel.report(
                request = ReportbacklogRequest(
                    star = mCalendarstar?.timeInMillis,
                    end =mCalendarend!!.timeInMillis
                )
            )
        }


    }
}