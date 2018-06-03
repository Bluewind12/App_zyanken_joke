package com.example.momonyan.app_zyanken_joke

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class ChoiceScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.janken_first)

        val rockButton = findViewById<Button>(R.id.gu_button)
        val scissorsButton = findViewById<Button>(R.id.choki_button)
        val paperButton = findViewById<Button>(R.id.pa_button)
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