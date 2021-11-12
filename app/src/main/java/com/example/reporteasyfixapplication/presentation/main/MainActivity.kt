package com.example.reporteasyfixapplication.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.reporteasyfixapplication.R
import com.example.reporteasyfixapplication.presentation.backlog.BacklogActivity
import com.example.reporteasyfixapplication.presentation.call.CallActivity
import com.example.reporteasyfixapplication.presentation.completejob.CompleteActivity
import com.example.reporteasyfixapplication.presentation.materialsreport.MaterialstActivity
import com.example.reporteasyfixapplication.presentation.profit.ProfitActivity
import com.example.reporteasyfixapplication.presentation.summarize.SumActivity
import com.example.reporteasyfixapplication.presentation.test.TestActivity
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
        b3.setOnClickListener {
            val intent=Intent(baseContext,CompleteActivity::class.java)
            startActivity(intent)
        }

        b4.setOnClickListener {
            val intent=Intent(baseContext,ProfitActivity::class.java)
            startActivity(intent)
        }
        b5.setOnClickListener {
            val  intent=Intent(baseContext,SumActivity::class.java)
            startActivity(intent)
        }
//        b6.setOnClickListener {
//            val  intent=Intent(baseContext, CallActivity::class.java)
//            startActivity(intent)
//        }

        b7.setOnClickListener {
            val  intent=Intent(baseContext, TestActivity::class.java)
            startActivity(intent)
        }
    }
}