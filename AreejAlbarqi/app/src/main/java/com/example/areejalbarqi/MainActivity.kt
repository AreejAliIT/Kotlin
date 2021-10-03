package com.example.areejalbarqi

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    // init component
    lateinit var input : EditText
    lateinit var btn : Button
    lateinit var rvMain : RecyclerView
    lateinit var tvHS : TextView
    lateinit var tvScore : TextView
    lateinit var tvEqu : TextView
    lateinit var equations : ArrayList<String>
    lateinit var sharedPreferences: SharedPreferences
    var increaseRandomNumber = 5
    var score = 0
    var flag = true
    var highScore: String =""

    // generate random numbers for the first time lunch
    var randomNum = Random.nextInt(0, increaseRandomNumber)
    var randomNum2 = Random.nextInt(1, 6)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        equations = ArrayList()
        //create the adaptor
        rvMain = findViewById<RecyclerView>(R.id.rvMain)
        rvMain.adapter = Equations(this, equations)
        rvMain.layoutManager = LinearLayoutManager(this)

        input = findViewById(R.id.input)
        btn = findViewById(R.id.submitBtn)
        tvHS = findViewById(R.id.tvHS)
        tvScore = findViewById(R.id.tvScore)
        tvEqu = findViewById(R.id.tvEqu)

        // Alert to start game
        showAlertDialog()
        // to set the Equation textView for the first time
        tvEqu.text = "$randomNum + " + "$randomNum2 = "

        btn.setOnClickListener{
            // call check func to check and add the result in recyclerView
            checkAnswer(randomNum ,randomNum2)
            // increasing the random number to make it more difficult
             this.increaseRandomNumber += 1
            // generate a new random numbers and set it to the textView
             randomNum = Random.nextInt(0, increaseRandomNumber)
             randomNum2 = Random.nextInt(1, 6)
            if(flag){
                tvEqu.text = "$randomNum + " + "$randomNum2 = "
            }else{
                tvEqu.text = "$randomNum - "+"$randomNum2 = "
            }

        }
        //Save the high score with shared preference
        sharedPreferences = this.getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        highScore = sharedPreferences.getString("highScore", "").toString()
        with(sharedPreferences.edit())
        {
            putString("highScore", highScore)
            apply()
        }
    }

    private fun checkAnswer(randomNum:Int , randomNum2:Int) {
        if(flag){
            var result = randomNum + randomNum2
            if (input.text.toString() == result.toString()) {
                equations.add("$randomNum + " + "$randomNum2 = $result")
                score++
                tvScore.text = "Score :" + score.toString()
                input.text.clear()
                input.clearFocus()
                rvMain.adapter?.notifyDataSetChanged()
            }else {
                equations.add("Wrong, The answer was $result")
                equations.add("New High Score!")
                tvHS.text = "High Score :" + score.toString()
                rvMain.adapter?.notifyDataSetChanged()
                PalyAgaineAlert()
            }
        }else{
            var result = randomNum - randomNum2
            if (input.text.toString() == result.toString()) {
                equations.add("$randomNum - " + "$randomNum2 = $result")
                score++
                tvScore.text = "Score :" + score.toString()
                input.text.clear()
                input.clearFocus()
                rvMain.adapter?.notifyDataSetChanged()
            }else {
                equations.add("Wrong, The answer was $result")
                equations.add("New High Score!")
                tvHS.text = "High Score :" + score.toString()
                rvMain.adapter?.notifyDataSetChanged()
                PalyAgaineAlert()
            }
        }

    }
    // Welcoming Alert
    private fun showAlertDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setMessage("Welcome to the mathe study app!\nHow many equation can you solve?")
            .setPositiveButton("START", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
        val alert = dialogBuilder.create()
        alert.setTitle("Math Study App")
        alert.show()

    }
    // Play Again Alert
    private fun PalyAgaineAlert() {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setMessage("Play again?")
            .setCancelable(false)
            .setPositiveButton("Yes", DialogInterface.OnClickListener {
                    dialog, id -> this.recreate()
            })
            .setNegativeButton("No", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
        val alert = dialogBuilder.create()
        alert.setTitle("Math study game")
        alert.show()
    }
    // set menu to inflater
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu , menu)
        return true
    }
    // set action when item selected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.Addition -> flag = true
            R.id.subtraction -> flag = false
        }
        return super.onOptionsItemSelected(item)
    }

}