package com.na.sadapay.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.na.sadapay.ui.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
