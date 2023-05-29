package com.example.educationmanagementsystem.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.educationmanagementsystem.databinding.ActivityFacultyBinding
import com.example.educationmanagementsystem.fragments.TeacherFragment

class FacultyActivity : AppCompatActivity() {
    private lateinit var binding:ActivityFacultyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFacultyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.cs.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("Identifier", "cs")
            val fragment = TeacherFragment()
            fragment.arguments = bundle
            binding.container.visibility = View.VISIBLE
            loadFragment(fragment)
        }
        binding.it.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("Identifier", "it")
            val fragment = TeacherFragment()
            fragment.arguments = bundle
            binding.container.visibility = View.VISIBLE
            loadFragment(fragment)
        }
        binding.ece.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("Identifier", "ece")
            val fragment = TeacherFragment()
            fragment.arguments = bundle
            binding.container.visibility = View.VISIBLE
            loadFragment(fragment)
        }
        binding.eee.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("Identifier", "eee")
            val fragment = TeacherFragment()
            fragment.arguments = bundle
            binding.container.visibility = View.VISIBLE
            loadFragment(fragment)
        }
    }
    private fun loadFragment(fragment: Fragment) {
        binding.container.visibility = View.VISIBLE
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.container.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onBackPressed() {
        val intent = Intent(this, EMSActivity::class.java)
        startActivity(intent)
    }
}