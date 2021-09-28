 package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movies = arrayListOf<String>()

    while (true) {
      println("Enter a movie:  ")
      movies.add(readLine()!!)
      if (movies.size >= 3){
        print("Would you add more movies? (y/n): ")
        if( readLine().toString() == "n")
          break
      }
    }
    println(movies)


    }
}
