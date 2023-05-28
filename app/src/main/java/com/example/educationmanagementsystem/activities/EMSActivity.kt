package com.example.educationmanagementsystem.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.educationmanagementsystem.databinding.ActivityEmsactivityBinding
import com.example.educationmanagementsystem.fragments.*


class EMSActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEmsactivityBinding
    private val sharedPrefFile = "kotlinsharedpreference"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmsactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences: SharedPreferences.Editor = this.getSharedPreferences(
            sharedPrefFile,
            Context.MODE_PRIVATE
        ).edit()
        binding.student.setOnClickListener {
            binding.stuOrFaculty.visibility =View.GONE
            binding.emsImage.visibility  =View.VISIBLE
            binding.studentSection.visibility = View.VISIBLE
            binding.appName.visibility = View.VISIBLE
        }
        binding.faculty.setOnClickListener {
            val intent = Intent(this, FacultyActivity::class.java)
            startActivity(intent)
        }
        binding.logout.setOnClickListener {
            Toast.makeText(this, "User logged out successfully!!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            sharedPreferences.putBoolean("isLoggedIn", false)
            sharedPreferences.apply()
            sharedPreferences.commit()
            this.startActivity(intent)
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

    override fun onBackPressed() {
        if (binding.appName.visibility == View.VISIBLE){
            binding.stuOrFaculty.visibility =View.VISIBLE
            binding.emsImage.visibility  =View.GONE
            binding.studentSection.visibility = View.GONE
            binding.appName.visibility = View.GONE
        }else{
            super.onBackPressed()
        }
    }
}