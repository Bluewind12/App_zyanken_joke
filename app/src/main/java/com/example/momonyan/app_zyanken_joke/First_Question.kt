package com.example.momonyan.app_zyanken_joke

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.view.animation.ScaleAnimation
import java.util.*


class First_Question : AppCompatActivity() {

    lateinit var gu: ImageView
    lateinit var choki: ImageView
    lateinit var pa: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.question_first)

        val ok_Button = findViewById(R.id.ok_Button) as Button

        val intentG = intent
        val intent = Intent(this, Result_Screen::class.java)
        intent.putExtra("choice", intentG.getStringExtra("choice"))

        gu = findViewById<ImageView>(R.id.gu)
        choki = findViewById<ImageView>(R.id.choki)
        pa = findViewById<ImageView>(R.id.pa)
        var flag = false
        ok_Button.setOnClickListener {
            if (!flag) {
                animationTemplate(selectRandom(), selectRandom(), intent)
                flag = true
            }
        }
    }

    private fun animationTemplate(scaleImage: ImageView, rotateImage: ImageView, intent: Intent) {
        val scaleAnimation = ScaleAnimation(1.0f, 2.5f, 1.0f, 2.5f)
        scaleAnimation.setDuration(5000)
        scaleAnimation.setFillAfter(true)
        scaleAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationEnd(animation: Animation) {
                val scaleDownAnimation = ScaleAnimation(2.5f, 1.0f, 2.5f, 1.0f)
                scaleDownAnimation.setDuration(3000)
                scaleDownAnimation.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationEnd(animation: Animation) {
                        Toast.makeText(this@First_Question, "なるほど", Toast.LENGTH_SHORT).show()
                        val rotateAnimation = RotateAnimation(0.0f, 360.0f * 5, rotateImage.getWidth() / 2.0f, rotateImage.getHeight() / 2.0f)
                        rotateAnimation.setDuration(6000)
                        rotateAnimation.setAnimationListener(object : Animation.AnimationListener {
                            override fun onAnimationEnd(animation: Animation) {
                                startActivity(intent)
                                Toast.makeText(this@First_Question, "AIの手が決まりました", Toast.LENGTH_LONG).show()
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