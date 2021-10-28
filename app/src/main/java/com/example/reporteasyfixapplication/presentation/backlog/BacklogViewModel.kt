package com.example.reporteasyfixapplication.presentation.backlog

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.reporteasyfixapplication.data.datasource.DataSource
import com.example.reporteasyfixapplication.data.models.ReportbacklogModel
import com.example.reporteasyfixapplication.data.request.ReportbacklogRequest
import com.example.reporteasyfixapplication.presentation.backlog.list.*
import com.google.gson.Gson
import java.text.SimpleDateFormat

class BacklogViewModel : ViewModel() {
    private var _report = MutableLiveData<FooderBacklog>()
    val report: LiveData<FooderBacklog>
        get() = _report

    fun report(request: ReportbacklogRequest) {
        val result = DataSource.reportbacklog(request)
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val report2 =
            FooderBacklog(
                sum = result.count(),
                listdate = result.map { db2 ->
                        ListBacklog1(
                            date = sdf.format(db2.date).toString(),
                            datesum = result.filter { sdf.format(db2.date).toString() == sdf.format(it.date).toString()}.count(),
                            listprovince = result.filter { sdf.format(db2.date) == sdf.format(it.date) }
                                .map { db3 ->
                                    ListBacklog2(
                                        province = db3.province.toString(),
                                        type = db3.type.toString(),
                                        home = db3.home.toString(),
                                        repairlist = db3.repairlist.toString()
                                    )
                                }
                        )
                    }.distinctBy { it.date }.sortedBy { it.date }
            )
        Log.d(TAG, "repair: ${Gson().toJson(report2)}")
        _report.value = report2
    }

    companion object {
        private const val TAG = "Report"
    }
}