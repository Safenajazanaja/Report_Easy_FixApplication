package com.example.reporteasyfixapplication.presentation.test

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.data.request.ReportbacklogRequest
import com.example.reporteasyfixapplication.presentation.test.adapter.ColumAdapter
import com.example.reporteasyfixapplication.presentation.test.adapter.List1Adapter
import kotlinx.android.synthetic.main.activity_materialst.*
import kotlinx.android.synthetic.main.activity_test.*
import java.util.*

class TestActivity : AppCompatActivity() {

    private var mCalendarstar: Calendar? = null
    private var mCalendarend: Calendar? = null
    var dateinmax: Long? = null
    private lateinit var viewModel:TestViewModel
    private val mColumAdapter = ColumAdapter()
    private val mList1 =List1Adapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        viewModel = ViewModelProvider(this).get(TestViewModel::class.java)

//        viewModel.report(
//            request = ReportbacklogRequest(
//                star = 1614786427043,
//                end = 1634066475223
//            )
//        )
        val adt = ConcatAdapter(
            mColumAdapter,mList1
        )
        recylerViewtest.apply {
            layoutManager=LinearLayoutManager(baseContext)
            adapter=adt
        }

        viewModel.report.observe(this,{
            mColumAdapter.submitData(Unit)
            mList1.submitList(it.listnamemat)
//            mfoodAdapter.submitData(it)

        })


        bt_dete_starttest.setOnClickListener {
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
                    bt_dete_starttest.setText("$dayOfMonth/${month.plus(1)}/$year")
                    bt_dete_endtest.visibility = View.VISIBLE

                    totexttest.visibility = View.VISIBLE


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

        bt_dete_endtest.setOnClickListener {
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
                    bt_dete_endtest.setText("$dayOfMonth/${month.plus(1)}/$year")
                    bt_oktest.visibility = View.VISIBLE
                    bt_oktest.isEnabled=true
                    totexttest.visibility= View.VISIBLE


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

        bt_oktest.setOnClickListener {
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