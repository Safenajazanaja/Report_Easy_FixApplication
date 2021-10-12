package com.example.reporteasyfixapplication.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.presentation.backlog.BacklogActivity
import com.example.reporteasyfixapplication.presentation.materialsreport.MaterialstActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b1.setOnClickListener {
            val intent= Intent(baseContext, BacklogActivity::class.java)
            startActivity(intent)

        }
        b2.setOnClickListener {
            val intent= Intent(baseContext, MaterialstActivity::class.java)
            startActivity(intent)
        }
    }
}