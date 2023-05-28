package com.example.educationmanagementsystem.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.educationmanagementsystem.R

class FacultyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faculty)
    }

    override fun onBackPressed() {

        val intent = Intent(this, EMSActivity::class.java)
        startActivity(intent)
    }
}