package com.example.momonyan.app_zyanken_joke

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageButton

class ChoiceScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.janken_first)

        val rockButton = findViewById<ImageButton>(R.id.gu_button)
        val scissorsButton = findViewById<ImageButton>(R.id.choki_button)
        val paperButton = findViewById<ImageButton>(R.id.pa_button)
        val winner = intent.getIntExtra("winner", 0)

        val nextIntent = Intent(this, QuestionScreen::class.java)
        nextIntent.putExtra("winner", winner)

        rockButton.setOnClickListener {
            nextIntent.putExtra("choice", "グー")
            startActivity(nextIntent)
        }
        scissorsButton.setOnClickListener {
            nextIntent.putExtra("choice", "チョキ")
            startActivity(nextIntent)
        }
        paperButton.setOnClickListener {
            nextIntent.putExtra("choice", "パー")
            startActivity(nextIntent)
        }
    }
}