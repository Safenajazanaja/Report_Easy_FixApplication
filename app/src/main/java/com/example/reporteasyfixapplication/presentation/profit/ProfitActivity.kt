package com.example.reporteasyfixapplication.presentation.profit

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.data.request.ReportbacklogRequest
import com.example.reporteasyfixapplication.presentation.materialsreport.MaterialstViewModel
import com.example.reporteasyfixapplication.presentation.materialsreport.adapter.ColumMatAdapter
import com.example.reporteasyfixapplication.presentation.materialsreport.adapter.FooderMatAdapter
import com.example.reporteasyfixapplication.presentation.materialsreport.adapter.ListMat1Adapter
import com.example.reporteasyfixapplication.presentation.profit.adapter.ColumProfitAdater
import com.example.reporteasyfixapplication.presentation.profit.adapter.FooderProfitAdapter
import com.example.reporteasyfixapplication.presentation.profit.adapter.ListProfit1Adapter
import kotlinx.android.synthetic.main.activity_complete.*
import kotlinx.android.synthetic.main.activity_materialst.*
import kotlinx.android.synthetic.main.activity_materialst.recylerViewmat
import kotlinx.android.synthetic.main.activity_profit.*
import kotlinx.android.synthetic.main.item_list1_profit.*
import java.util.*

class ProfitActivity : AppCompatActivity() {
    private var mCalendarstar: Calendar? = null
    private var mCalendarend: Calendar? = null
    var dateinmax: Long? = null
    private val mfoodAdapter = FooderProfitAdapter()
    private val mList1 = ListProfit1Adapter()
    private val mColumAdapter = ColumProfitAdater()
    private lateinit var viewModel: ProfitViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profit)
        viewModel = ViewModelProvider(this).get(ProfitViewModel::class.java)

//        viewModel.report(
//            request = ReportbacklogRequest(
//                star = 1614786427043,
//                end = 1634066475223
//            )
//        )


        val adt = ConcatAdapter(
            mColumAdapter, mList1, mfoodAdapter
        )

        recylerViewprofit.apply {
            layoutManager = LinearLayoutManager(baseContext)
            adapter = adt
        }

        viewModel.report.observe(this,{
            mColumAdapter.submitData(Unit)
            mList1.submitList(it.listnametec)
            mfoodAdapter.submitData(it)
        })

        bt_dete_startpro.setOnClickListener {
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
                    bt_dete_startpro.setText("$dayOfMonth/${month.plus(1)}/$year")
                    bt_dete_endpro.visibility = View.VISIBLE

                    totextpro.visibility = View.VISIBLE


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

        bt_dete_endpro.setOnClickListener {
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
                    bt_dete_endpro.setText("$dayOfMonth/${month.plus(1)}/$year")
                    bt_okpro.visibility = View.VISIBLE
                    bt_okpro.isEnabled=true
                    totextpro.visibility= View.VISIBLE


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

        bt_okpro.setOnClickListener {
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