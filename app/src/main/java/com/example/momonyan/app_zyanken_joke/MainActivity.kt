package com.example.momonyan.app_zyanken_joke

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val start = findViewById(R.id.startB) as Button
        start.setOnClickListener {
            Toast.makeText(this, "Test", Toast.LENGTH_LONG).show()
        }
    }
}
