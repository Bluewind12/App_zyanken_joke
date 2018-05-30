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
        startButton = findViewById(R.id.startB) as Button
        startButton.setOnClickListener {
            Toast.makeText(this, "Test", Toast.LENGTH_LONG).show()
            val intant = Intent(this,firstChoiceScreen::class.java)
            startActivity(intant)
        }
    }
}
