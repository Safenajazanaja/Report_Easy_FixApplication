package com.example.reporteasyfixapplication.presentation.call

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.data.request.ReportbacklogRequest
import com.example.reporteasyfixapplication.presentation.call.adapter.ColumCallAdapter
import com.example.reporteasyfixapplication.presentation.call.adapter.FooderCallAdapter
import com.example.reporteasyfixapplication.presentation.call.adapter.List1CallAdapter
import com.example.reporteasyfixapplication.presentation.completejob.CompleteVireModel
import kotlinx.android.synthetic.main.activity_call.*
import kotlinx.android.synthetic.main.activity_complete.*
import java.util.*

class CallActivity : AppCompatActivity() {
    private var mCalendarstar: Calendar? = null
    private var mCalendarend: Calendar? = null
    private lateinit var viewModel:CallViewModel
    private val mfoodAdapter = FooderCallAdapter()
    private val mColumAdapter = ColumCallAdapter()
    private val mList1 = List1CallAdapter()
    var dateinmax: Long? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call)
        viewModel = ViewModelProvider(this).get(CallViewModel::class.java)

//        viewModel.report(
//            request = ReportbacklogRequest(
//                star = 1614786427043,
//                end = 1634066475223
//            )
//        )


        val adt = ConcatAdapter(
            mColumAdapter,mList1, mfoodAdapter
        )
        recylerViewcall.apply {
            layoutManager=LinearLayoutManager(baseContext)
            adapter=adt
        }
        viewModel.report.observe(this,{
            mColumAdapter.submitData(Unit)
            mfoodAdapter.submitData(it)
            mList1.submitList(it.listdate)
        })


        bt_dete_startcall.setOnClickListener {
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
                    bt_dete_startcall.setText("$dayOfMonth/${month.plus(1)}/$year")
                    bt_dete_endcall.visibility = View.VISIBLE

                    totextcall.visibility = View.VISIBLE


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

        bt_dete_endcall.setOnClickListener {
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
                    bt_dete_endcall.setText("$dayOfMonth/${month.plus(1)}/$year")
                    bt_okcall.visibility = View.VISIBLE
                    bt_okcall.isEnabled=true
                    totextcall.visibility= View.VISIBLE


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

        bt_okcall.setOnClickListener {
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