package com.example.reporteasyfixapplication.data.map

import com.example.reporteasyfixapplication.data.database.Material
import com.example.reporteasyfixapplication.data.database.Orderl
import com.example.reporteasyfixapplication.data.database.Status
import com.example.reporteasyfixapplication.data.database.Users
import com.example.reporteasyfixapplication.data.models.ReportCallModel
import org.jetbrains.exposed.sql.ResultRow

object ReportCallMap {
    fun toReportCall(row: ResultRow) = ReportCallModel(
        datestart = row[Orderl.dateLong],
        userid = row[Orderl.user_id],
        name = row[Users.fullname],
        idjob = row[Orderl.order_id],
        dateexpect = row[Orderl.period],
        statsid = row[Orderl.status],
        stats = row[Status.status_name],
        dateend = row[Orderl.date_end],
        matername = row[Material.material_name]
    )


}