package com.example.momonyan.app_zyanken_joke

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import android.graphics.Color
import android.widget.ImageView


class ResultScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_screen)
        val resultButton = findViewById<Button>(R.id.result_Button)
        val aiHandImageView = findViewById<ImageView>(R.id.ai_Hand_Image)
        val yourHandImageView = findViewById<ImageView>(R.id.your_Hand_Image)
        val resultText = findViewById<TextView>(R.id.result_Text)
        val selectHand = intent.getStringExtra("choice")
        val winner = intent.getIntExtra("win", 0)
        var aiHand: String
        var clickCheck = false


        resultButton.setOnClickListener {
            if (winner == 0 && !clickCheck) {
                aiHand = winHand(selectHand)
                setImage(aiHand, aiHandImageView)
                setImage(selectHand, yourHandImageView)
                resultText.setText(R.string.lose)
                resultText.setTextColor(Color.BLUE)
                resultButton.setText(R.string.reset)
                clickCheck = true
            } else if (winner == 1 && !clickCheck) {
                aiHand = loseHand(selectHand)
                setImage(aiHand, aiHandImageView)
                setImage(selectHand, yourHandImageView)
                resultText.setText(R.string.win)
                resultText.setTextColor(Color.RED)
                resultButton.setText(R.string.reset)
                clickCheck = true
            } else if (winner == 2 && !clickCheck) {
                aiHand = selectHand
                setImage(aiHand, aiHandImageView)
                setImage(selectHand, yourHandImageView)
                resultText.setText(R.string.draw)
                resultText.setTextColor(Color.GREEN)
                resultButton.setText(R.string.reset)
                clickCheck = true
            } else {
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                startActivity(intent)
            }
        }
    }

    private fun winHand(hand: String): String {
        when {
            hand == "グー" -> return "パー"
            hand == "チョキ" -> return "グー"
            hand == "パー" -> return "チョキ"
            else -> error("選択されてないエラー")
        }
    }

    private fun loseHand(hand: String): String {
        when {
            hand == "グー" -> return "チョキ"
            hand == "チョキ" -> return "パー"
            hand == "パー" -> return "グー"
            else -> error("選択されてないエラー")
        }
    }

    private fun setImage(hand: String, imageView: ImageView) {
        when {
            hand == "グー" -> imageView.setImageResource(R.drawable.janken_gu)
            hand == "チョキ" -> imageView.setImageResource(R.drawable.janken_choki)
            hand == "パー" -> imageView.setImageResource(R.drawable.janken_pa)
            else -> error("選択されてないエラー")
        }
    }
}