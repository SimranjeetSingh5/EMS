package com.example.educationmanagementsystem.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.educationmanagementsystem.databinding.ActivityEmsactivityBinding
import com.example.educationmanagementsystem.fragments.AttendanceFragment
import com.example.educationmanagementsystem.fragments.FeesFragment
import com.example.educationmanagementsystem.fragments.LibraryFragment
import com.example.educationmanagementsystem.fragments.PerformanceFragment


class EMSActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEmsactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmsactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.logout.setOnClickListener {
            Toast.makeText(this, "User logged out successfully!!", Toast.LENGTH_SHORT).show()
            this.finish()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.performance.setOnClickListener {
            val fragment: Fragment
            fragment = PerformanceFragment()
            binding.container.visibility = View.VISIBLE
            loadFragment(fragment)
        }
        binding.attendance.setOnClickListener {

            val attFragment: Fragment
            attFragment = AttendanceFragment()
            binding.container.visibility = View.VISIBLE
            loadFragment(attFragment)
        }
        binding.library.setOnClickListener {

            val attFragment: Fragment
            attFragment = LibraryFragment()
            binding.container.visibility = View.VISIBLE
            loadFragment(attFragment)
        }
        binding.fees.setOnClickListener {

            val attFragment: Fragment
            attFragment = FeesFragment()
            binding.container.visibility = View.VISIBLE
            loadFragment(attFragment)
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.container.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}