package com.example.helloworldkotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.awt.font.TextAttribute

class MainActivity2 : AppCompatActivity() {
     lateinit var plus : Button
     lateinit var minus : Button
     lateinit var text : TextView
     var num =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        plus = findViewById(R.id.btnPlus)
        minus = findViewById(R.id.btnMinus)
        text = findViewById(R.id.textView)
        plus.setOnClickListener{add()}
        minus.setOnClickListener{minus()}

    }
    fun add() {
        if(num > 0){
            num ++
            text.text=num.toString()
            text.setTextColor(Color.GREEN)
        }else{
            num ++
            text.text=num.toString()
            text.setTextColor(Color.RED)
        }
    }
    fun minus() {
        if(num > 0){
            num --
            text.text=num.toString()
            text.setTextColor(Color.GREEN)
        }else{
            num --
            text.text=num.toString()
            text.setTextColor(Color.RED)
        }

    }

}