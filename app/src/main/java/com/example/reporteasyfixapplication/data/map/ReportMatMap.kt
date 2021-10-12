package com.example.reporteasyfixapplication.data.map

import com.example.reporteasyfixapplication.data.database.Material
import com.example.reporteasyfixapplication.data.database.Orderl_detail
import com.example.reporteasyfixapplication.data.database.Technician
import com.example.reporteasyfixapplication.data.models.ReportMatModel
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.sum

object ReportMatMap {
    fun  toReportMater(row: ResultRow)= ReportMatModel(
        nametec = row[Technician.fullname],
        mater_name = row[Material.material_name],
        mater_count = row[Orderl_detail.qty],
        price_mater = row[Material.price_material],
        )
}