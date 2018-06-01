package com.example.momonyan.app_zyanken_joke

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
  private lateinit var startButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startButton = findViewById<Button>(R.id.startB)
        startButton.setOnClickListener {
            Toast.makeText(this, "Test", Toast.LENGTH_LONG).show()
            val intant = Intent(this,First_Choice_Screen::class.java)
            startActivity(intant)
        }
    }
}
