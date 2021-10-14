package com.example.reporteasyfixapplication.presentation.backlog

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.data.request.ReportbacklogRequest
import com.example.reporteasyfixapplication.presentation.backlog.adater.ColumBacklogAdapter
import com.example.reporteasyfixapplication.presentation.backlog.adater.FooderBacklogAdapter
import com.example.reporteasyfixapplication.presentation.backlog.adater.ListBacklog1Adapter
import kotlinx.android.synthetic.main.activity_backlog.*
import java.util.*

class BacklogActivity : AppCompatActivity() {
    private var mCalendarstar: Calendar? = null
    private var mCalendarend: Calendar? = null
    var dateinmax: Long? = null
    private val mfoodAdapter = FooderBacklogAdapter()
    private val mList1 = ListBacklog1Adapter()
    private val mColumAdapter = ColumBacklogAdapter()
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


        viewModel.report.observe(this,{
            mColumAdapter.submitData(Unit)
            mfoodAdapter.submitData(it)
            mList1.submitList(it.listdate)
        })


        bt_dete_start.setOnClickListener {
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
                        bt_dete_start.setText("$dayOfMonth/${month.plus(1)}/$year")
                        bt_dete_end.visibility = View.VISIBLE

                        totext.visibility = View.VISIBLE


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
        bt_dete_end.setOnClickListener {
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
                        bt_dete_end.setText("$dayOfMonth/${month.plus(1)}/$year")
                        bt_okhis.visibility = View.VISIBLE
                        bt_okhis.isEnabled=true
                        totext.visibility=View.VISIBLE


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

        bt_okhis.setOnClickListener {
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