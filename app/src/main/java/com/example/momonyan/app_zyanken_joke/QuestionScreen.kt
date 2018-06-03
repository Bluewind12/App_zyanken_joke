package com.example.momonyan.app_zyanken_joke

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.view.animation.ScaleAnimation
import java.util.*


class QuestionScreen : AppCompatActivity() {

    private lateinit var gu: ImageView
    private lateinit var choki: ImageView
    private lateinit var pa: ImageView
    private var flagCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.question_first)

        val okButton = findViewById<Button>(R.id.ok_Button)

        val intentG = intent
        val intent = Intent(this, ResultScreen::class.java)
        intent.putExtra("choice", intentG.getStringExtra("choice"))
        intent.putExtra("win", intentG.getIntExtra("winner", 0))

        gu = findViewById(R.id.gu)
        choki = findViewById(R.id.choki)
        pa = findViewById(R.id.pa)
        var flag = false
        okButton.setOnClickListener {
            if (!flag) {
                animationTemplate(selectRandom(), selectRandom(), intent)
                flag = true
            } else {
                flagCount++
            }
        }
    }

    private fun animationTemplate(scaleImage: ImageView, rotateImage: ImageView, intent: Intent) {
        val scaleAnimation = ScaleAnimation(1.0f, 2.5f, 1.0f, 2.5f)
        scaleAnimation.duration = 5000
        scaleAnimation.fillAfter = true
        scaleAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationEnd(animation: Animation) {
                val scaleDownAnimation = ScaleAnimation(2.5f, 1.0f, 2.5f, 1.0f)
                scaleDownAnimation.duration = 3000
                scaleDownAnimation.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationEnd(animation: Animation) {
                        if (flagCount != 1) {
                            intent.putExtra("win", 0)
                        }
                        Toast.makeText(this@QuestionScreen, "なるほど", Toast.LENGTH_SHORT).show()
                        val rotateAnimation = RotateAnimation(0.0f, 360.0f * 5, rotateImage.getWidth() / 2.0f, rotateImage.getHeight() / 2.0f)
                        rotateAnimation.duration = 6000
                        rotateAnimation.setAnimationListener(object : Animation.AnimationListener {
                            override fun onAnimationEnd(animation: Animation) {
                                if (flagCount != 3) {
                                    intent.putExtra("win", 0)
                                }
                                startActivity(intent)
                                Toast.makeText(this@QuestionScreen, "AIの手が決まりました", Toast.LENGTH_LONG).show()
                            }

                            override fun onAnimationRepeat(animation: Animation) {}
                            override fun onAnimationStart(animation: Animation) {}
                        })
                        rotateImage.startAnimation(rotateAnimation)
                    }

                    override fun onAnimationRepeat(animation: Animation) {}
                    override fun onAnimationStart(animation: Animation) {}
                })
                scaleImage.startAnimation(scaleDownAnimation)

            }

            override fun onAnimationRepeat(animation: Animation) {}
            override fun onAnimationStart(animation: Animation) {}
        })
        scaleImage.startAnimation(scaleAnimation)
    }

    private fun selectRandom(): ImageView {
        val random = Random().nextInt(100)
        when {
            random % 3 == 0 -> return gu
            random % 3 == 1 -> return choki
            random % 3 == 2 -> return pa
            else -> error("ランダムの値とかがおかしい")
        }
    }

}