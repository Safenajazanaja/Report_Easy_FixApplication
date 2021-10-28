package com.example.reporteasyfixapplication.data.map

import com.example.reporteasyfixapplication.data.database.Orderl
import com.example.reporteasyfixapplication.data.database.Pay
import com.example.reporteasyfixapplication.data.models.ReportSumModel
import org.jetbrains.exposed.sql.ResultRow

object ReportSum {
    fun toReportSum(row: ResultRow) = ReportSumModel(
        date = row[Orderl.dateLong],
        payjob = row[Orderl.pay_type],
        nametypejob = row[Pay.pay_type]
    )
}