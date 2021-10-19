package com.example.reporteasyfixapplication.presentation.profit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.reporteasyfixapplication.data.datasource.DataSource
import com.example.reporteasyfixapplication.data.request.ReportbacklogRequest
import com.example.reporteasyfixapplication.presentation.materialsreport.MaterialstViewModel
import com.example.reporteasyfixapplication.presentation.materialsreport.list.FooderMat
import com.example.reporteasyfixapplication.presentation.profit.list.Fooderprofit
import com.example.reporteasyfixapplication.presentation.profit.list.Listprofit1
import com.google.gson.Gson

class ProfitViewModel:ViewModel() {

    private var _report = MutableLiveData<Fooderprofit>()
    val report: LiveData<Fooderprofit>
        get() = _report

    fun report(request: ReportbacklogRequest){
        val result=DataSource.reportpofit(request)
        val report=Fooderprofit(
            sumtec = result.sumBy { it.sumjob!! },
            listnametec = result.map { db ->
                Listprofit1(
                    name_tec = db.nametec,
                    sumjob = result.filter { it.nametec==db.nametec }.count(),
                    sumprofit = result.filter { it.nametec==db.nametec }.sumBy { it.sumjob!! }

                )
            }.distinctBy { it.name_tec }
        )

        _report.value=report
        Log.d(TAG, "repair3: ${Gson().toJson(report)}")
    }

    companion object {
        private const val TAG = "Report"
    }
}