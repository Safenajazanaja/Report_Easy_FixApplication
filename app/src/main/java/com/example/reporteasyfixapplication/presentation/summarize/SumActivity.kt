package com.example.reporteasyfixapplication.presentation.summarize

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.data.request.ReportbacklogRequest
import com.example.reporteasyfixapplication.presentation.summarize.adapter.ColumSumAdapter
import com.example.reporteasyfixapplication.presentation.summarize.adapter.FooderSumAdapter
import com.example.reporteasyfixapplication.presentation.summarize.adapter.ListSum1Adapter
import kotlinx.android.synthetic.main.activity_backlog.*
import kotlinx.android.synthetic.main.activity_materialst.*
import kotlinx.android.synthetic.main.activity_materialst.recylerViewmat
import kotlinx.android.synthetic.main.activity_profit.*
import kotlinx.android.synthetic.main.activity_sum.*
import java.util.*

class SumActivity : AppCompatActivity() {
    private var mCalendarstar: Calendar? = null
    private var mCalendarend: Calendar? = null
    var dateinmax: Long? = null
    private lateinit var viewModel: SumViewModel
    private val mColumAdapter =ColumSumAdapter()
    private val mList1 = ListSum1Adapter()
    private val mFooer=FooderSumAdapter()
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sum)
        viewModel = ViewModelProvider(this).get(SumViewModel::class.java)
//        viewModel.report(
//            request = ReportbacklogRequest(
//                star = 1614786427043,
//                end = 1635748169232
//            )
//        )


        val adt = ConcatAdapter(
            mColumAdapter,mList1,mFooer
        )
            recylerViewsum.apply {
            layoutManager = LinearLayoutManager(baseContext)
            adapter = adt
        }
        viewModel.report.observe(this,{
            mColumAdapter.submitData(Unit)
            mList1.submitList(it.list1)
            mFooer.submitData(it)

        })

            bt_dete_startsum.setOnClickListener {
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
                        bt_dete_startsum.setText("$dayOfMonth/${month.plus(1)}/$year")
                        bt_dete_endsum.visibility = View.VISIBLE

                        totextsum.visibility = View.VISIBLE


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

            bt_dete_endsum.setOnClickListener {
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
                        bt_dete_endsum.setText("$dayOfMonth/${month.plus(1)}/$year")
                        bt_oksum.visibility = View.VISIBLE
                        bt_oksum.isEnabled=true
                        totextsum.visibility= View.VISIBLE


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

//                .show()
                dateDialog.show()
            }

            bt_oksum.setOnClickListener {
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