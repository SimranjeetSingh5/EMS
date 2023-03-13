package com.example.educationmanagementsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.educationmanagementsystem.databinding.ActivityEmsactivityBinding

class EMSActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEmsactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmsactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.back.setOnClickListener {
            onBackPressed()
        }
    }
}