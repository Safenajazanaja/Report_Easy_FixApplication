package com.example.reporteasyfixapplication.data.models

data class ReportCallModel(
    val datestart:Long,
    val userid: Int,
    val name: String,
    val idjob:Int,
    val dateexpect:Long,
    val statsid:Int,
    val stats:String,
    val dateend:Long,
    val matername:String
)
