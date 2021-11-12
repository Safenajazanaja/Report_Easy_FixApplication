package com.example.reporteasyfixapplication.presentation.call.list

import com.example.reporteasyfixapplication.presentation.completejob.list.ListCom1

data class FooderCall(
    val sumuser: Int?=null,
    val sumjobcompleted: Int?=null,
    val sumnot: Int?=null,
    val listdate:List<ListDate1>
)
