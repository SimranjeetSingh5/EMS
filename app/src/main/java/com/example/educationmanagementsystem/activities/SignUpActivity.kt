package com.example.educationmanagementsystem.activities

import android.R
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View.OnFocusChangeListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.educationmanagementsystem.databinding.ActivitySignUpBinding
import java.text.SimpleDateFormat
import java.util.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private val sharedPrefFile = "kotlinsharedpreference"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dataList = arrayListOf<Any?>("Male", "Female", "Other")
        val arrayAdapter: ArrayAdapter<*> =
            ArrayAdapter<Any?>(this, R.layout.simple_list_item_1, dataList)
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(
            sharedPrefFile,
            Context.MODE_PRIVATE
        )

        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        binding.gender.setAdapter(arrayAdapter)
        binding.gender.inputType = 0
        binding.gender.onFocusChangeListener =
            OnFocusChangeListener { v, hasFocus -> if (hasFocus) binding.gender.showDropDown() }

        binding.dob.editText?.setText(SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()))

        val cal = Calendar.getInstance()

        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val myFormat = "dd/MM/yyyy"
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                binding.dob.editText?.setText(sdf.format(cal.time))

            }
        binding.back.setOnClickListener {
            onBackPressed()
        }

        binding.dob.editText?.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                DatePickerDialog(
                    this, dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
        }
        binding.submitBtn.setOnClickListener {
            if (isValidate()) {
                editor.putString("mobile_key", binding.mobile.editText?.text.toString())
                editor.putString("password_key", binding.password.editText?.text.toString())
                editor.apply()
                editor.commit()
                val intent = Intent(this, EMSActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please Fill All Details", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun isValidate(): Boolean {
        if (binding.fullName.editText?.text.isNullOrEmpty())
            return false
        else if (binding.fatherName.editText?.text.isNullOrEmpty())
            return false
        else if (binding.motherName.editText?.text.isNullOrEmpty())
            return false
        else if (binding.mobile.editText?.text.isNullOrEmpty())
            return false
        else if (binding.email.editText?.text.isNullOrEmpty())
            return false
        else if (binding.password.editText?.text.isNullOrEmpty())
            return false
        else if (binding.gender.text.isNullOrEmpty())
            return false
        else if (binding.dob.editText?.text.isNullOrEmpty())
            return false
        else if (binding.state.editText?.text.isNullOrEmpty())
            return false
        else if (binding.city.editText?.text.isNullOrEmpty())
            return false
        else if (binding.pan.editText?.text.isNullOrEmpty())
            return false

        return true
    }
}