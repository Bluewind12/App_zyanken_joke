package com.example.momonyan.app_zyanken_joke

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var winner = 0   //0:AI , 1:player , 2:draw
        val startButton = findViewById<Button>(R.id.startB)
        val winImageView = findViewById<ImageButton>(R.id.winImage)
        val drawImageView = findViewById<ImageButton>(R.id.drawImage)
        startButton.setOnClickListener {
            val nextIntent = Intent(this, ChoiceScreen::class.java)
            nextIntent.putExtra("winner", winner)
            startActivity(nextIntent)
        }
        winImageView.setOnClickListener {
            winner = 1
        }
        drawImageView.setOnClickListener {
            winner = 2
        }
    }

}
