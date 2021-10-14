package com.example.reporteasyfixapplication.presentation.completejob

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.data.request.ReportbacklogRequest
import com.example.reporteasyfixapplication.presentation.completejob.adapter.ColumCompleteAdapter
import com.example.reporteasyfixapplication.presentation.completejob.adapter.FooderCompleteAdapter
import com.example.reporteasyfixapplication.presentation.completejob.adapter.ListComplete1Adapter
import com.example.reporteasyfixapplication.presentation.materialsreport.adapter.ColumMatAdapter
import com.example.reporteasyfixapplication.presentation.materialsreport.adapter.FooderMatAdapter
import com.example.reporteasyfixapplication.presentation.materialsreport.adapter.ListMat1Adapter
import kotlinx.android.synthetic.main.activity_complete.*
import kotlinx.android.synthetic.main.activity_materialst.*
import java.util.*

class CompleteActivity : AppCompatActivity() {
    private var mCalendarstar: Calendar? = null
    private var mCalendarend: Calendar? = null
    var dateinmax: Long? = null
    private val mfoodAdapter = FooderCompleteAdapter()
    private val mList1 = ListComplete1Adapter()
    private val mColumAdapter = ColumCompleteAdapter()
    private lateinit var viewModel:CompleteVireModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete)
        viewModel = ViewModelProvider(this).get(CompleteVireModel::class.java)

//        viewModel.report(
//            request = ReportbacklogRequest(
//                star = 1614786427043,
//                end = 1634066475223
//            )
//        )

        val adt = ConcatAdapter(
            mColumAdapter, mList1, mfoodAdapter
        )
        recylerViewcom.apply {
            layoutManager = LinearLayoutManager(baseContext)
            adapter = adt
        }

        viewModel.report.observe(this,{
            mColumAdapter.submitData(Unit)
            mList1.submitList(it.listnamecom)
            mfoodAdapter.submitData(it)
        })


        bt_dete_startcom.setOnClickListener {
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
                    bt_dete_startcom.setText("$dayOfMonth/${month.plus(1)}/$year")
                    bt_dete_endcom.visibility = View.VISIBLE

                    totextcom.visibility = View.VISIBLE


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

        bt_dete_endcom.setOnClickListener {
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
                    bt_dete_endcom.setText("$dayOfMonth/${month.plus(1)}/$year")
                    bt_okcom.visibility = View.VISIBLE
                    bt_okcom.isEnabled=true
                    totextcom.visibility= View.VISIBLE


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

        bt_okcom.setOnClickListener {
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