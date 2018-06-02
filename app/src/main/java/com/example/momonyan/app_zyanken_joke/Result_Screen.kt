package com.example.momonyan.app_zyanken_joke

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import android.graphics.Color
import android.widget.ImageView


class Result_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_screen)
        val resultButton = findViewById<Button>(R.id.result_Button)
        val aiHandImageView = findViewById<ImageView>(R.id.ai_Hand_Image)
        val yourHandImageView = findViewById<ImageView>(R.id.your_Hand_Image)
        val resultText = findViewById<TextView>(R.id.result_Text)
        val selectHand = intent.getStringExtra("choice")
        val ai_hand = winHand(selectHand)
        var clickCheck = false

        resultButton.setOnClickListener {
            if (!clickCheck) {
                setImage(ai_hand, aiHandImageView)
                setImage(selectHand, yourHandImageView)
                resultText.setText("あなたの負けです")
                resultText.setTextColor(Color.BLUE)
                resultButton.setText("最初に戻る")
                clickCheck = true
            } else {
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                startActivity(intent)
            }
        }
        //TODO 勝利条件を満たしている場合の処理を行う
        //TODO 引き分けも入れる？
    }

    private fun winHand(hand: String): String {
        when {
            hand.equals("グー") -> return "パー"
            hand.equals("チョキ") -> return "グー"
            hand.equals("パー") -> return "チョキ"
            else -> error("選択されてないエラー")
        }
    }

    private fun loseHand(hand: String): String {
        when {
            hand.equals("グー") -> return "チョキ"
            hand.equals("チョキ") -> return "パー"
            hand.equals("パー") -> return "グー"
            else -> error("選択されてないエラー")
        }
    }

    private fun setImage(hand: String, imageView: ImageView) {
        when {
            hand.equals("グー") -> imageView.setImageResource(R.drawable.janken_gu)
            hand.equals("チョキ") -> imageView.setImageResource(R.drawable.janken_choki)
            hand.equals("パー") -> imageView.setImageResource(R.drawable.janken_pa)
            else -> error("選択されてないエラー")
        }
    }
}