package com.example.reporteasyfixapplication.presentation.completejob

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.reporteasyfixapplication.data.datasource.DataSource
import com.example.reporteasyfixapplication.data.request.ReportbacklogRequest
import com.example.reporteasyfixapplication.presentation.backlog.BacklogViewModel
import com.example.reporteasyfixapplication.presentation.completejob.list.FooderCom
import com.example.reporteasyfixapplication.presentation.completejob.list.ListCom1
import com.example.reporteasyfixapplication.presentation.completejob.list.ListCom2
import com.google.gson.Gson
import java.text.SimpleDateFormat

class CompleteVireModel : ViewModel() {
    private var _report = MutableLiveData<FooderCom>()
    val report: LiveData<FooderCom>
        get() = _report

    fun report(request: ReportbacklogRequest){
        val result=DataSource.reportcom(request)
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val report=FooderCom(
            sum = result.count(),
            listnamecom = result.map { db1 ->
                ListCom1(
                    date = sdf.format(db1.date).toString(),
                    datesum = result.filter { sdf.format(it.date).toString()==sdf.format(db1.date).toString() }.count(),
                    listtec = result.filter { sdf.format(it.date).toString()==sdf.format(db1.date).toString() }
                        .map { db2 ->
                        ListCom2(
                            nametec = db2.nametec.toString(),
                            type = db2.type.toString(),
                            dateend = sdf.format(db2.dateend).toString()

                        )
                    }
                )
            }.distinctBy { it.date }
        )

        Log.d(TAG, "reportCom: ${Gson().toJson(report)}")
        _report.value=report
    }
    companion object {
        private const val TAG = "ReportCom"
    }
}