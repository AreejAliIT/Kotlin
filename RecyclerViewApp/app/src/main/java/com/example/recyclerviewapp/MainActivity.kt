package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var myCL: ConstraintLayout
    private lateinit var input: EditText
    private lateinit var btn: Button
    private lateinit var Activities: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myCL = findViewById(R.id.myCL)
        Activities = ArrayList()

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.adapter = ActivityAdapter( this,Activities)
        recyclerView.layoutManager = LinearLayoutManager(this)

        input = findViewById(R.id.input)
        btn = findViewById(R.id.btn)

        btn.setOnClickListener { addActivity() }
    }


    private fun addActivity(){
        val act = input.text.toString()
        if(act.isNotEmpty()){
            Activities.add(act)
            input.text.clear()
        }else{
            Snackbar.make(myCL, "Please enter your activity:", Snackbar.LENGTH_LONG).show()
        }
    }
}