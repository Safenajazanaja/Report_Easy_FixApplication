package com.example.reporteasyfixapplication.presentation.backlog.list


data class ListBacklog1(
    val date: String,
    val datesum: Int,
    val listprovince: List<ListBacklog2>
)