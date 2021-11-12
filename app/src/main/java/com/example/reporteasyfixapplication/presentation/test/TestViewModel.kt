package com.example.reporteasyfixapplication.presentation.test

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.reporteasyfixapplication.data.datasource.DataSource
import com.example.reporteasyfixapplication.data.request.ReportbacklogRequest
import com.example.reporteasyfixapplication.presentation.materialsreport.MaterialstViewModel
import com.example.reporteasyfixapplication.presentation.test.list.Foodertest
import com.example.reporteasyfixapplication.presentation.test.list.Listtest1
import com.example.reporteasyfixapplication.presentation.test.list.Listtest2
import com.google.gson.Gson
import java.text.SimpleDateFormat

class TestViewModel : ViewModel() {
    private var _report = MutableLiveData<Foodertest>()
    val report: LiveData<Foodertest>
        get() = _report


    fun report(request: ReportbacklogRequest) {
        val result = DataSource.reportmat(request)
        val sdf = SimpleDateFormat("dd/MM/yyyy")

        val report = Foodertest(
            listnamemat = result.map { db1 ->
                Listtest1(
                    matername = db1.mater_name,
                    summat = result.filter { it.mater_name == db1.mater_name }
                        .sumBy { it.mater_count!!.toInt() },
                    listMat2 = result.filter { it.mater_name == db1.mater_name }.map { db2 ->
                        Listtest2(
                            mater_date = sdf.format(db2.date),
                            mater_qty = db2.mater_count
                        )
                    }
                )
            }.distinctBy { it.matername }
        )


        _report.value = report
        Log.d(TAG, "repair3: ${Gson().toJson(result)}")
    }

    companion object {
        private const val TAG = "Report"
    }
}