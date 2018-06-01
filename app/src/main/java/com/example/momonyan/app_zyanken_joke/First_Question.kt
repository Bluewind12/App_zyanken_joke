package com.example.momonyan.app_zyanken_joke

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.ImageView

class First_Question :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.question_first)

        val ok_Button = findViewById<Button>(R.id.ok_Button)
        val gu = findViewById<ImageView>(R.id.gu)
        val choki = findViewById<ImageView>(R.id.choki)
        val pa = findViewById<ImageView>(R.id.pa)


        ok_Button.setOnClickListener {
            val alphaDown = AlphaAnimation(1.0f,0.0f)
            val alphaUp = AlphaAnimation(0.0f,1.0f)
            alphaDown.duration(3000)
            alphaDown.

        }
    }
}