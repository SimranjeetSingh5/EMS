package com.example.educationmanagementsystem.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.educationmanagementsystem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val sharedPrefFile = "kotlinsharedpreference"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.signUpBtn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(
            sharedPrefFile,
            Context.MODE_PRIVATE
        )
        if (sharedPreferences.getBoolean("isLoggedIn",false)){
            val intent = Intent(this, EMSActivity::class.java)
            startActivity(intent)
        }
        binding.loginBtn.setOnClickListener {
            val editor = sharedPreferences.edit()
            val sharedMobileValue = sharedPreferences.getString("mobile_key", "defaultmobile")
            val sharedPasswordValue = sharedPreferences.getString("password_key", "defaultkey")
            editor.putBoolean("isLoggedIn",true)
            if (binding.phoneEditText.editText?.text.toString() != sharedMobileValue || binding.phoneEditText.editText?.text.toString()
                    .isEmpty()
            ) {
                Toast.makeText(this, "Not a valid user", Toast.LENGTH_SHORT).show()
            } else if (binding.passwordEditText.editText?.text.toString() != sharedPasswordValue || binding.passwordEditText.editText?.text.toString()
                    .isEmpty()
            ) {
                Toast.makeText(this, "Password is wrong", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, EMSActivity::class.java)
                startActivity(intent)
            }
            editor.apply()
//            editor.clear()
        }
    }
}