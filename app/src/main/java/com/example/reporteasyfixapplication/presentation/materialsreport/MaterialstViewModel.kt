package com.example.reporteasyfixapplication.presentation.materialsreport

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.reporteasyfixapplication.data.datasource.DataSource
import com.example.reporteasyfixapplication.data.request.ReportbacklogRequest
import com.example.reporteasyfixapplication.presentation.materialsreport.list.FooderMat
import com.example.reporteasyfixapplication.presentation.materialsreport.list.ListMat1
import com.example.reporteasyfixapplication.presentation.materialsreport.list.ListMat2
import com.google.gson.Gson
import java.text.SimpleDateFormat

class MaterialstViewModel : ViewModel() {
    private var _report = MutableLiveData<FooderMat>()
    val report: LiveData<FooderMat>
        get() = _report

    fun report(request: ReportbacklogRequest) {
        val result = DataSource.reportmat(request)
        Log.d(TAG, "repair2: ${Gson().toJson(result)}")
//        val report= FooderMat(
//                sum = result.filter {it.nametec ==it.nametec}.filter { it.mater_name == it.mater_name }.distinctBy { it.mater_name }.count(),
//                listnametec = result.map { db ->
//                    ListMat1(
//                        name_tec = db.nametec,
//                        summat = result.filter { db.nametec == it.nametec }.distinctBy { it.mater_name }.count(),
//                        listMat2 = result.filter { db.nametec ==it.nametec }.map {db2 ->
//                            ListMat2(
//                                mater_name = db2.mater_name,
//                                mater_qty = result.filter {it.nametec ==db2.nametec}.filter { it.mater_name == db2.mater_name }.sumBy { it.mater_count!!.toInt() }
//                            )
//                        }.distinctBy { it.mater_name }
//                    )
//                }.distinctBy { it.name_tec }
//            )
        val sdf = SimpleDateFormat("dd/MM/yyyy")

        val report= FooderMat(
            sum = result.filter { sdf.format(it.date)==sdf.format(it.date) }.count(),
            listnamemat = result.map { db ->
                ListMat1(
                    date = sdf.format(db.date).toString(),
                    summat = result.filter { sdf.format(db.date) == sdf.format(it.date) }.count(),
                    listMat2 = result.filter { sdf.format(db.date) == sdf.format(it.date) }.map {db2 ->
                        ListMat2(
                            mater_name = db2.mater_name,
                            mater_qty = result.filter { it.mater_name == db2.mater_name }.filter { sdf.format(it.date)==sdf.format(db2.date) }.sumBy { it.mater_count!!.toInt() }
                        )
                    }.distinctBy { it.mater_name }
                )
            }.distinctBy { it.date }
        )
        _report.value=report
        Log.d(TAG, "repair3: ${Gson().toJson(result)}")
    }


    companion object {
        private const val TAG = "Report"
    }
}