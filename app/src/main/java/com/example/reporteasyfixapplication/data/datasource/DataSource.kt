package com.example.reporteasyfixapplication.data.datasource


import android.util.Log


import com.example.engineerapplication.data.response.LoginResponse
import com.example.reporteasyfixapplication.data.database.*
import com.example.reporteasyfixapplication.data.map.ReportMatMap
import com.example.reporteasyfixapplication.data.map.ReportbacklogMap
import com.example.reporteasyfixapplication.data.models.ReportMatModel
import com.example.reporteasyfixapplication.data.models.ReportbacklogModel
import com.example.reporteasyfixapplication.data.request.LoginRequest
import com.example.reporteasyfixapplication.data.request.ReportbacklogRequest
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction


object DataSource {

    private const val TAG = "####"

    fun login(request: LoginRequest): LoginResponse {
        val response = LoginResponse()
        val result = transaction {
            addLogger(StdOutSqlLogger)

            Technician.select {
                Technician.username eq request.username
            }
                .andWhere { Technician.password eq request.password }
                .count()
                .toInt()

        }

        if (result == 1) {
            val userId = transaction {
                Technician.slice(Technician.technician_id)
                    .select { Technician.username eq request.username }
                    .andWhere { Technician.password eq request.password }
                    .map { it[Technician.technician_id] }
                    .single()
            }
            response.userId = userId
            response.success = true
//            Log.d(ContentValues.TAG, "onActivityCreated: "+userId)
        } else {
            response.success = false
        }
        return response
    }

    fun reportbacklog(request: ReportbacklogRequest):List<ReportbacklogModel>{
        return  transaction {
            addLogger(StdOutSqlLogger)
            (Orderl innerJoin Province innerJoin District innerJoin Amphur innerJoin  Type_job)
                    .slice(
                            Province.province_name,
                            Amphur.amphur_name,
                            District.district_name,
                            Type_job.namejob,
                            Orderl.dateLong,
                            Orderl.abode,
                            Orderl.repair_list
                    )
                    .select { Orderl.dateLong.between(request.star,request.end) }
                    .andWhere { Orderl.province_id eq  Province.province_id }
                    .andWhere { Orderl.district_id eq District.district_id }
                    .andWhere { Orderl.amphur_id eq Amphur.amphur_id }
                    .andWhere { Orderl.type_job eq Type_job.type_job_id }
                    .map { ReportbacklogMap.toReportbacklog(it) }
        }

    }

    fun reportmat(request: ReportbacklogRequest):List<ReportMatModel>{
        return  transaction {
            addLogger(StdOutSqlLogger)
            (Technician innerJoin Orderl innerJoin Orderl_detail innerJoin Material)
                .slice(
                    Technician.fullname,
                    Material.material_name,
                    Material.price_material,
                    Orderl_detail.qty
                )
                .select { Orderl.dateLong.between(request.star,request.end) }
                .andWhere { Orderl.order_id eq Orderl_detail.orderl_id }
                .andWhere { Orderl.id_technician eq Technician.technician_id }
                .andWhere { Orderl_detail.material_id eq Material.material_id }
                .map { ReportMatMap.toReportMater(it) }
        }

    }

}

