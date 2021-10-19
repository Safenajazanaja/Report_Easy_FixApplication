package com.example.reporteasyfixapplication.data.map

import com.example.reporteasyfixapplication.data.database.Orderl
import com.example.reporteasyfixapplication.data.database.Technician
import com.example.reporteasyfixapplication.data.models.ReportProfitModel
import com.example.reporteasyfixapplication.data.models.ReportbacklogModel
import org.jetbrains.exposed.sql.ResultRow

object ReportProfitMap {
    fun toReportProfit(row: ResultRow) = ReportProfitModel(
        nametec = row[Technician.fullname],
        sumjob = row[Orderl.price]
    )
}