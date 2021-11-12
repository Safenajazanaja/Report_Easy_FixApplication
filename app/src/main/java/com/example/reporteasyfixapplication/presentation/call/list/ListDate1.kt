package com.example.reporteasyfixapplication.presentation.call.list

data class ListDate1(
    val sumuserdate: Int?=null,
    val sumjobcompleteddate: Int?=null,
    val sumnotdate: Int?=null,
    val datestart:String?=null,
    val listid:List<ListId2>
)
