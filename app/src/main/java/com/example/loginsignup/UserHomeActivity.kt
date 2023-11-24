package com.example.loginsignup

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class UserHomeActivity : AppCompatActivity() {

    private lateinit var textViewWelcome: TextView
    private lateinit var spinnerTests: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userhome)

        textViewWelcome = findViewById(R.id.textViewWelcome)
        spinnerTests = findViewById(R.id.spinnerTests)

        textViewWelcome.text = "Welcome, User!"

        val adapter = ArrayAdapter(
            this,
            R.layout.spinner_item_layout,
            getTestData()
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTests.adapter = adapter

        spinnerTests.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                val selectedTest = parentView?.getItemAtPosition(position) as String
                Toast.makeText(applicationContext, "Selected Test: $selectedTest", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Do nothing here
            }
        }
    }

    private fun getTestData(): List<String> {
        return listOf("Blood Test", "Urine Test", "Lipid Test")
    }

    fun logout(view: View) {
        finish()
    }

    fun openActivity(view: View) {
        // Implement logic to open corresponding activity
        // For simplicity, let's leave this empty
    }
}
