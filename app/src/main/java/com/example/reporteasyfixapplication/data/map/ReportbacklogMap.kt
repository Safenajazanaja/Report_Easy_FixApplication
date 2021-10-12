package com.example.reporteasyfixapplication.data.map

import com.example.reporteasyfixapplication.data.database.*
import com.example.reporteasyfixapplication.data.models.ReportMatModel
import com.example.reporteasyfixapplication.data.models.ReportbacklogModel
import org.jetbrains.exposed.sql.ResultRow

object ReportbacklogMap {
    fun toReportbacklog(row: ResultRow) = ReportbacklogModel(
            province = row[Province.province_name],
            amphur_name = row[Amphur.amphur_name],
            district_name = row[District.district_name],
            date = row[Orderl.dateLong],
            type = row[Type_job.namejob],
            home = row[Orderl.abode],
            repairlist = row[Orderl.repair_list],
    )

}