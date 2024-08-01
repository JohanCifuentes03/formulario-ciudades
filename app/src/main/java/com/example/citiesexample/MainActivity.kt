package com.example.citiesexample

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var edCity : EditText
    private lateinit var btAddCity : Button
    private lateinit var btDeleteCity : Button
    private lateinit var lvCities : ListView
    private lateinit var adapter : ArrayAdapter<String>

    private lateinit var cities : ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edCity = findViewById(R.id.edCity)
        btAddCity = findViewById(R.id.btAddCity)
        btDeleteCity = findViewById(R.id.btDeleteCity)
        lvCities = findViewById(R.id.lvCities)

        cities = ArrayList()

        adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            cities
        )

        lvCities.adapter = adapter

        btAddCity.setOnClickListener {
            addCity()
        }

        btDeleteCity.setOnClickListener {
            deleteCity()
        }
    }

    private fun addCity() {
        val city = edCity.text.toString().trim()
        if (city.isNotEmpty()) {
            cities.add(city)
            adapter.notifyDataSetChanged()
            edCity.text.clear()
        }
    }

    private fun deleteCity() {
        val city = edCity.text.toString().trim()
        if (city.isNotEmpty() && cities.contains(city)) {
            cities.remove(city)
            adapter.notifyDataSetChanged()
            edCity.text.clear()
        }
    }
}
