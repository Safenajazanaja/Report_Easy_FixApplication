package com.example.reporteasyfixapplication.presentation.call

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.reporteasyfixapplication.data.datasource.DataSource
import com.example.reporteasyfixapplication.data.request.ReportbacklogRequest
import com.example.reporteasyfixapplication.presentation.call.list.FooderCall
import com.example.reporteasyfixapplication.presentation.call.list.ListDate1
import com.example.reporteasyfixapplication.presentation.call.list.ListId2
import com.example.reporteasyfixapplication.presentation.call.list.ListMater
import com.example.reporteasyfixapplication.presentation.completejob.CompleteVireModel
import com.example.reporteasyfixapplication.presentation.materialsreport.list.FooderMat
import com.google.gson.Gson
import java.text.SimpleDateFormat

class CallViewModel : ViewModel() {
    private var _report = MutableLiveData<FooderCall>()
    val report: LiveData<FooderCall>
        get() = _report

    fun report(request: ReportbacklogRequest) {
        val result = DataSource.reportcall(request)
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val report = FooderCall(
            sumuser = result.filter { it.userid == it.userid }.distinctBy { it.userid }.count(),
            sumnot = result.filter { it.statsid !=4}.distinctBy { it.idjob }.count(),
            sumjobcompleted = result.filter { it.statsid==4}.distinctBy { it.idjob }.count(),
            listdate = result.map { db ->
                ListDate1(
                    datestart = sdf.format(db.datestart),
                    sumjobcompleteddate = result.filter {sdf.format(db.datestart)==sdf.format(it.datestart) }.filter { it.statsid==4 }.distinctBy { it.idjob }.count(),
                    sumnotdate = result.filter {sdf.format(db.datestart)==sdf.format(it.datestart) }.filter { it.statsid!=4 }.distinctBy { it.idjob }.count(),
                    sumuserdate=result.filter {sdf.format(db.datestart)==sdf.format(it.datestart)}.groupBy { it.userid }.count(),
                    listid = result.filter {sdf.format(db.datestart)==sdf.format(it.datestart)  }.map { db2 ->
                        ListId2(
                            userid = db2.userid,
                            name = db2.name,
                            idjob = db2.idjob.toString(),
                            dateexpect = sdf.format(db2.dateexpect),
                            stats = db2.stats,
                            dateend = sdf.format(db2.dateend),
                            listmater = result.filter { it.idjob==db2.idjob }.map {
                                ListMater(
                                    matername = it.matername
                                )
                            }
                        )

                    }.distinctBy { it.idjob }
                )
            }.distinctBy { it.datestart }
        )
        _report.value=report
        Log.d(TAG, "reportCom: ${Gson().toJson(result)}")

    }

    companion object {
        private const val TAG = "ReportCall"
    }
}