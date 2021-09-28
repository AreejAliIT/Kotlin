package com.example.guessthephrase

import android.content.ReceiverCallNotAllowedException
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var input : EditText
    lateinit var btn : Button
    lateinit var messages : ArrayList<String>
    lateinit var myCL : ConstraintLayout
    lateinit var rvMain : RecyclerView
    lateinit var txtPromet : TextView
    lateinit var textView : TextView

    private val answer = "Hi there"
    private var myAnswer = ""
    private var myDictionary = mutableMapOf<Int, String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myCL = findViewById(R.id.myCL)
        messages = ArrayList()

        rvMain=findViewById<RecyclerView>(R.id.rvMain)
        rvMain.adapter = Message(this , messages)
        rvMain.layoutManager = LinearLayoutManager(this)

        txtPromet = findViewById(R.id.textView)
        textView =findViewById(R.id.textView)
        input = findViewById(R.id.input)
        btn  =findViewById(R.id.btn)

        convertLetterToSatr(answer)
        btn.setOnClickListener {  checkGuess(input.text.toString())}
    }

    private fun convertLetterToSatr(answer:String) {
        for(e in answer.indices){
            if(answer[e].equals(" ")) {
                myDictionary[e] = " "
                myAnswer += " "
            }else{
                myDictionary[e] = "*"
                myAnswer += "*"
            }
        }
        txtPromet.text = myDictionary.toString()
    }
    private fun checkGuess(inpu : String){

        if(inpu.contentEquals(answer) ){
            textView.setTextColor(Color.GREEN)
            textView.text = "You Got it!!"
            messages.add("You guessed $inpu that is ture!")
        }else{
            textView.setTextColor(Color.RED)
            textView.text = "Wrong try again! "

            messages.add("You guessed $inpu and the answer was $answer")
        }
        input.text.clear()
        input.clearFocus()
        rvMain.adapter?.notifyDataSetChanged()
    }
}

