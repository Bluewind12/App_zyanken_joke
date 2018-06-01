package com.example.momonyan.app_zyanken_joke

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import android.view.animation.Animation
import java.util.*


class First_Question : AppCompatActivity() {
    lateinit var gu: ImageView
    lateinit var choki: ImageView
    lateinit var pa: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.question_first)

        val ok_Button = findViewById(R.id.ok_Button) as Button
        val gu = findViewById<ImageView>(R.id.gu)
        val choki = findViewById<ImageView>(R.id.choki)
        val pa = findViewById<ImageView>(R.id.pa)

        ok_Button.setOnClickListener {
            //TODO Image Rotate Random
            val upAlpha = AlphaAnimation(0.0f, 1.0f)
            upAlpha.setDuration(3000)
            upAlpha.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationEnd(animation: Animation) {
                    //TODO Activity create
                    Log.d("Animation_Test","EndAnimation")
                }
                override fun onAnimationRepeat(animation: Animation) {}
                override fun onAnimationStart(animation: Animation) {}

            })
            gu.startAnimation(upAlpha)
        }

    }

}