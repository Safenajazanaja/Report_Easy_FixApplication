package com.example.reporteasyfixapplication.presentation.backlog

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.reporteasyfixapplication.data.datasource.DataSource
import com.example.reporteasyfixapplication.data.request.ReportbacklogRequest
import com.example.reporteasyfixapplication.presentation.backlog.list.*
import com.google.gson.Gson
import java.text.SimpleDateFormat

class BacklogViewModel : ViewModel() {
    private var _report = MutableLiveData<Fooder>()
    val report: LiveData<Fooder>
        get() = _report

    fun report(request: ReportbacklogRequest) {
        val result = DataSource.reportbacklog(request)
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val report2 =
            Fooder(
                    data1 = result.count(),
                    list1 = result//.filter { it.province.toString() == db.province.toString() }
                            .map { db2 ->
                                List1(
                                        province = db2.province.toString(),
                                        provincesum = result.filter { db2.province.toString() == it.province.toString()}.count(),
//                                        listamphur_name = result.filter { db2.amphur_name.toString() == it.amphur_name.toString() }
//                                                .map { db3 ->
//                                                    List2(
//                                                            amphur_name = db3.amphur_name.toString(),
//                                                            listamphur_name = result.filter { it.district_name.toString() == db3.district_name.toString() }
//                                                                    .map { db4 ->
//                                                                        List3(
//                                                                                district_name = db4.district_name.toString(),
//                                                                                listdistrict_name = result.filter { it.type.toString() == db4.type.toString() }
//                                                                                        .map { db5 ->
//                                                                                            List4(
//                                                                                                    typejob = db5.type.toString(),
//                                                                                                    listdate = result.filter { sdf.format(it.date) == sdf.format(db5.date) }
//                                                                                                            .map { db6 ->
//                                                                                                                List5(
//                                                                                                                        date = sdf.format(db6.date).toString(),
//                                                                                                                        listhome = result.filter { it.home.toString() == db6.home.toString() }
//                                                                                                                                .map {
//                                                                                                                                    List6(
//                                                                                                                                            home = it.home.toString(),
//                                                                                                                                            repairlist = it.repairlist.toString()
//                                                                                                                                    )
//                                                                                                                                }
//
//                                                                                                                )
//                                                                                                            }
//                                                                                            )
//                                                                                        }.distinctBy { it.typejob }
//                                                                        )
//                                                                    }.distinctBy { it.district_name }
//                                                    )
//                                                }.distinctBy { it.amphur_name}
                                )
                            }.distinctBy { it.province }
            )
//        }.distinctBy { it.list1}
        Log.d(TAG, "repair: ${Gson().toJson(report2)}")
        _report.value=report2
    }
    companion object {
        private const val TAG = "Report"
    }
}