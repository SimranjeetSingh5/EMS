package com.example.educationmanagementsystem.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.educationmanagementsystem.adapter.CalendarAdapter
import com.example.educationmanagementsystem.adapter.SubjectAdapter
import com.example.educationmanagementsystem.databinding.ActivityEmsactivityBinding
import com.example.educationmanagementsystem.databinding.FragmentAttendanceBinding
import com.example.educationmanagementsystem.models.SubjectData
import com.example.educationmanagementsystem.utils.CalendarUtils
import com.example.educationmanagementsystem.utils.CalendarUtils.daysInWeekArray
import com.example.educationmanagementsystem.utils.CalendarUtils.monthYearFromDate
import java.time.LocalDate


class AttendanceFragment : Fragment(), CalendarAdapter.OnItemListener {
    private lateinit var binding: FragmentAttendanceBinding
    private lateinit var subjectAdapter: SubjectAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAttendanceBinding.inflate(layoutInflater, container, false)
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.back.setOnClickListener {
            activity?.onBackPressed()
        }
        CalendarUtils.selectedDate = LocalDate.now()
        setWeekView()

    }


    private fun setWeekView() {
        binding.monthYearTV.text = monthYearFromDate(CalendarUtils.selectedDate!!)
        val days: ArrayList<LocalDate?> = daysInWeekArray(CalendarUtils.selectedDate!!)
        val calendarAdapter = CalendarAdapter(days, this)
        val layoutManager: RecyclerView.LayoutManager =
            GridLayoutManager(activity, 7)
        binding.calendarRecyclerView.layoutManager = layoutManager
        binding.calendarRecyclerView.adapter = calendarAdapter
        binding.previous.setOnClickListener {
            previousWeekAction()
        }
        binding.forward.setOnClickListener {
            nextWeekAction()
        }
        setEventAdapter()
    }


    private fun previousWeekAction() {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate!!.minusWeeks(1)
        setWeekView()
    }

    private fun nextWeekAction() {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate!!.plusWeeks(1)
        setWeekView()
    }

    override fun onItemClick(position: Int, date: LocalDate?) {
        CalendarUtils.selectedDate = date
        setSubjectData(CalendarUtils.selectedDate?.dayOfWeek?.value)
        setWeekView()
    }

    private fun setEventAdapter() {
        subjectAdapter = SubjectAdapter(requireActivity().baseContext)
        binding.subjectRV.layoutManager = GridLayoutManager(activity, 1)
        binding.subjectRV.adapter = subjectAdapter
        setSubjectData(CalendarUtils.selectedDate?.dayOfWeek?.value)
    }

    private fun setSubjectData(selectedDate: Int?) {
        when (selectedDate) {
            1 -> {
                subjectAdapter.subjectList = arrayListOf(
                    SubjectData("Discrete Maths-I", 34, true),
                    SubjectData("Automata", 11, false),
                    SubjectData("Computer Networks", 24, true),
                    SubjectData("Operating System", 14, true)
                )
                binding.subjectRV.adapter?.notifyDataSetChanged()
            }
            2 -> {
                subjectAdapter.subjectList = arrayListOf(
                    SubjectData("Embedded Systems", 10, true),
                    SubjectData("DBMS", 2, false),
                    SubjectData("Web Development-HTML/CSs", 34, true)
                )
                binding.subjectRV.adapter?.notifyDataSetChanged()
            }
            3 -> {
                subjectAdapter.subjectList = arrayListOf(
                    SubjectData("Physics", 40, true),
                    SubjectData("Software Engineering", 25, false),
                )
                binding.subjectRV.adapter?.notifyDataSetChanged()
            }
            4 -> {
                subjectAdapter.subjectList = arrayListOf(
                    SubjectData("Object Oriented Analysis", 31, true),
                    SubjectData("Data communications", 30, false),
                    SubjectData("Data Communication-Practical", 4, true)
                )
                binding.subjectRV.adapter?.notifyDataSetChanged()
            }
            5 -> {
                subjectAdapter.subjectList = arrayListOf(
                    SubjectData("Engg Maths-I", 35, true),
                    SubjectData("DBMS", 34, false),
                    SubjectData("Web Development-HTML/CSs", 34, true)
                )
                binding.subjectRV.adapter?.notifyDataSetChanged()
            }
        }
    }
}