package com.example.reporteasyfixapplication.presentation.call.list

data class ListId2(
    val userid: Int?=null,
    val name: String?=null,
    val idjob:String?=null,
    val dateexpect:String?=null,
    val stats:String?=null,
    val dateend:String?=null,
    val listmater:List<ListMater>
)
