package com.example.educationmanagementsystem.fragments

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.educationmanagementsystem.R
import com.example.educationmanagementsystem.databinding.ActivityEmsactivityBinding
import com.example.educationmanagementsystem.databinding.FragmentPerformanceBinding
import com.example.educationmanagementsystem.models.UserData
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.MPPointF

class PerformanceFragment : Fragment() {
    private lateinit var binding: FragmentPerformanceBinding
    private lateinit var activityEmsactivityBinding: ActivityEmsactivityBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPerformanceBinding.inflate(layoutInflater, container, false)
        activityEmsactivityBinding = ActivityEmsactivityBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myContext = requireActivity().baseContext
        activityEmsactivityBinding.appName.text = "Student Performance"
        activityEmsactivityBinding.back.setImageDrawable(ContextCompat.getDrawable(myContext,R.drawable.ic_back))
        binding.pieChart.setUsePercentValues(true)
        binding.pieChart.description.isEnabled = false
        binding.pieChart.setExtraOffsets(5f, 10f, 5f, 5f)
        binding.pieChart.dragDecelerationFrictionCoef = 0.95f
        binding.pieChart.isDrawHoleEnabled = true
        binding.pieChart.setHoleColor(Color.WHITE)
        binding.pieChart.holeRadius = 58f
        binding.pieChart.transparentCircleRadius = 61f
        binding.pieChart.rotationAngle = 0f
        binding.pieChart.isRotationEnabled = true
        binding.pieChart.isHighlightPerTapEnabled = true
        binding.pieChart.animateY(1400, Easing.EaseOutElastic)
        binding.pieChart.legend.isEnabled = false
        binding.pieChart.setEntryLabelColor(Color.WHITE)
        binding.pieChart.setEntryLabelTextSize(12f)

        val userData = UserData()
        val dataSet = PieDataSet(userData.scores, "Mobile OS")
        dataSet.setDrawIcons(false)
        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(0f, 40f)
        dataSet.selectionShift = 5f
        val colors: ArrayList<Int> = arrayListOf(
            ContextCompat.getColor(myContext, R.color.purple_200),
            ContextCompat.getColor(myContext, R.color.teal_700),
            ContextCompat.getColor(myContext, R.color.red)
        )
        dataSet.colors = colors
        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter())
        data.setValueTextSize(15f)
        data.setValueTypeface(Typeface.DEFAULT_BOLD)
        data.setValueTextColor(Color.WHITE)
        binding.pieChart.data = data
        binding.pieChart.highlightValues(null)
        binding.pieChart.invalidate()
    }

}