package com.example.reporteasyfixapplication.presentation.summarize

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.reporteasyfixapplication.data.datasource.DataSource
import com.example.reporteasyfixapplication.data.request.ReportbacklogRequest
import com.example.reporteasyfixapplication.presentation.materialsreport.list.FooderMat
import com.example.reporteasyfixapplication.presentation.summarize.list.FooderSum
import com.example.reporteasyfixapplication.presentation.summarize.list.ListSum1
import com.example.reporteasyfixapplication.presentation.summarize.list.ListSum2
import com.google.gson.Gson
import java.text.SimpleDateFormat

class SumViewModel : ViewModel() {

    private var _report = MutableLiveData<FooderSum>()
    val report: LiveData<FooderSum>
        get() = _report


    fun report(request: ReportbacklogRequest) {
        val result = DataSource.reportsum(request)
        Log.d(TAG, "repair2: ${Gson().toJson(result)}")
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val report = FooderSum(
            sumcompleted = result.filter { it.payjob == 2 }.count(),
            sumwait = result.filter { it.payjob != 2 }.count(),
            list1 = result.map { db ->
                ListSum1(
                    date = sdf.format(db.date),
                    sumwait = result.filter { sdf.format(it.date) == sdf.format(db.date) }.filter { it.payjob != 2 }.count(),
                    sumjob = result.filter { sdf.format(it.date) == sdf.format(db.date) }.count(),
                    sumcomple = result.filter { sdf.format(it.date) == sdf.format(db.date) }.filter { it.payjob == 2 }.count()
                )
            }.distinctBy { it.date }
        )
        _report.value = report
        Log.d(TAG, "repair3: ${Gson().toJson(report)}")
    }

    companion object {
        private const val TAG = "Report"
    }
}