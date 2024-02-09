package com.example.assignment1_kaitlinseldon_erikaramirez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.name_department_year)
        val img = findViewById<ImageView>(R.id.profile_picture)

        val spinnerItems = resources.getStringArray(R.array.profiles)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerItems)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                when (spinnerItems[position]) {
                    "Select an profile..." -> img.setImageResource(R.drawable.place_holder)
                    "Kaitlin Seldon, Computer Science, 2024" -> img.setImageResource(R.drawable.avatar_4_raster)
                    "Erika Ramirez, Computer Science, 2024" -> img.setImageResource(R.drawable.avatar_8_raster)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        findViewById<Button>(R.id.grade).setOnClickListener{
            val numEntry : Int
            val entry = findViewById<EditText>(R.id.enter_grade_number).text.toString()
            val tvNewGrade = findViewById<TextView>(R.id.new_grade)
            if (entry.isNotEmpty()) {
                numEntry = entry.toInt()
                tvNewGrade.text = getGrade(numEntry)
            } else {
                tvNewGrade.text = "Please enter valid integer"
                //Toast.makeText(this, "Please enter valid integer", Toast.LENGTH_LONG).show()
            }
        }
        //findViewById<Button>(R.id.grade).setOnClickListener{
        //    startActivity(Intent(this, GradeActivity::class.java))
        //}
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