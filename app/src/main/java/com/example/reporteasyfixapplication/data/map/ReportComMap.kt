package com.example.reporteasyfixapplication.data.map

import com.example.reporteasyfixapplication.data.database.Orderl
import com.example.reporteasyfixapplication.data.database.Technician
import com.example.reporteasyfixapplication.data.database.Type_job
import com.example.reporteasyfixapplication.data.models.ReportComModel
import org.jetbrains.exposed.sql.ResultRow
import java.lang.reflect.Type

object ReportComMap {
    fun toReportCom(row: ResultRow)=ReportComModel(
        date = row[Orderl.dateLong],
        nametec = row[Technician.fullname],
        type = row[Type_job.namejob],
        dateend = row[Orderl.date_end]
    )
}