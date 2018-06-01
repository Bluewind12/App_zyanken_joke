package com.example.momonyan.app_zyanken_joke

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

class firstChoiceScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.janken_first)
        val rock_Button = findViewById<Button>(R.id.gu_button)
        val scissors_Button = findViewById<Button>(R.id.choki_button)
        val paper_Button = findViewById<Button>(R.id.pa_button)

        rock_Button.setOnClickListener {
            val intent = Intent(this, First_Question::class.java)
            startActivity(intent)
        }
        scissors_Button.setOnClickListener {
            val intent = Intent(this, First_Question::class.java)
            startActivity(intent)

        }
        paper_Button.setOnClickListener {
            val intent = Intent(this, First_Question::class.java)
            startActivity(intent)
        }


    }

}