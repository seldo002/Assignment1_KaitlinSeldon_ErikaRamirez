package com.example.assignment1_kaitlinseldon_erikaramirez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class GradeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grade)

        findViewById<Button>(R.id.show_grade).setOnClickListener {
            val numEntry: Int
            val entry = findViewById<EditText>(R.id.enter_grade_number).text.toString()
            val tvNewGrade = findViewById<TextView>(R.id.new_grade)
            if (entry.isNotEmpty()) {
                numEntry = entry.toInt()
                tvNewGrade.text = getGrade(numEntry)
            } else {
                //tvNewGrade.text = "Please enter valid integer"
                Toast.makeText(applicationContext, "Please enter valid integer", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

   fun getGrade(numEntry: Int) : String {
       val tvNewGrade: String
       if (numEntry > 94) {
           tvNewGrade = "You got an A!"
       } else if (numEntry in 90..93) {
           tvNewGrade = "You got an A-"
       } else if (numEntry in 87..89) {
           tvNewGrade = "You got a B+"
       } else if (numEntry in 83..86) {
           tvNewGrade = "You got a B"
       } else if (numEntry in 80..82) {
           tvNewGrade = "You got a B-"
       } else if (numEntry in 77..79) {
           tvNewGrade = "You got a C+"
       } else if (numEntry in 73..76) {
           tvNewGrade = "You got a C"
       } else if (numEntry in 70..72) {
           tvNewGrade = "You got a C-"
       } else {
           tvNewGrade = "You got an F!!!"
       }
            return tvNewGrade
       }

}