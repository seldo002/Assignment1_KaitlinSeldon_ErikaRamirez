package com.example.assignment1_kaitlinseldon_erikaramirez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner

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
                    "Kaitlin Seldon, Computer Science, 2024" -> img.setImageResource(R.drawable.avatar_4_raster)
                    "Erika Ramirez, Computer Science, 2024" -> img.setImageResource(R.drawable.avatar_8_raster)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
}}