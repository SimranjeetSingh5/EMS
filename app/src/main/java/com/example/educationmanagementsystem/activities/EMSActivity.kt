package com.example.educationmanagementsystem.activities

import android.R
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.educationmanagementsystem.databinding.ActivityEmsactivityBinding
import com.example.educationmanagementsystem.fragments.PerformanceFragment


class EMSActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEmsactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmsactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.performance.setOnClickListener {
            val fragment: Fragment
            fragment = PerformanceFragment()
            binding.container.visibility = View.VISIBLE
            loadFragment(fragment) }
    }

    private fun loadFragment(fragment: PerformanceFragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.container.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}