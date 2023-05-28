package com.example.educationmanagementsystem.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.educationmanagementsystem.R
import com.example.educationmanagementsystem.adapter.SubjectAdapter
import com.example.educationmanagementsystem.databinding.ActivityEmsactivityBinding
import com.example.educationmanagementsystem.databinding.FragmentAttendanceBinding
import com.example.educationmanagementsystem.databinding.FragmentFacultyBinding
import com.example.educationmanagementsystem.utils.CalendarUtils
import java.time.LocalDate

class FacultyFragment : Fragment() {
    private lateinit var binding: FragmentFacultyBinding
    private lateinit var activityBinding: ActivityEmsactivityBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFacultyBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activityBinding = ActivityEmsactivityBinding.inflate(layoutInflater)
        activityBinding.root.visibility = View.GONE
//        activityBinding.stuOrFaculty.visibility =View.VISIBLE
//        activityBinding.emsImage.visibility  =View.GONE
//        activityBinding.studentSection.visibility = View.GONE
//        activityBinding.appName.visibility = View.GONE
    }
}