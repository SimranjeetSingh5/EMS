package com.example.educationmanagementsystem.fragments

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
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
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.MPPointF
import java.math.RoundingMode
import java.text.DecimalFormat

class PerformanceFragment : Fragment() {
    private var count: Int = 0
    private lateinit var binding: FragmentPerformanceBinding
    private lateinit var activityEmsactivityBinding: ActivityEmsactivityBinding
    private lateinit var scoresList: ArrayList<UserData>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPerformanceBinding.inflate(layoutInflater, container, false)
        activityEmsactivityBinding =
            ActivityEmsactivityBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activityEmsactivityBinding.appName.text = "Student Performance"
        val myContext: Context = requireActivity().baseContext
        activityEmsactivityBinding.back.setImageDrawable(
            ContextCompat.getDrawable(
                myContext,
                R.drawable.ic_back
            )
        )
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
        binding.pieChart.animateY(1400, Easing.EaseInOutQuad)
        binding.pieChart.legend.isEnabled = false
        binding.pieChart.setEntryLabelColor(Color.WHITE)
        binding.pieChart.setEntryLabelTextSize(12f)
        scoresList = arrayListOf<UserData>(
            UserData(
                arrayListOf(
                    PieEntry(92.4f),
                    PieEntry(41.2f),
                    PieEntry(43.6f),
                    PieEntry(33.3f),
                    PieEntry(3.0f)
                )
            ), UserData(
                arrayListOf(
                    PieEntry(51.4f),
                    PieEntry(88.2f),
                    PieEntry(12.6f),
                    PieEntry(19.3f),
                    PieEntry(50.0f)
                )
            ), UserData(
                arrayListOf(
                    PieEntry(9.4f),
                    PieEntry(91.2f),
                    PieEntry(43.6f),
                    PieEntry(33.3f),
                    PieEntry(69.0f)
                )
            ), UserData(
                arrayListOf(
                    PieEntry(77.4f),
                    PieEntry(61.2f),
                    PieEntry(41.6f),
                    PieEntry(3.3f),
                    PieEntry(39.0f)
                )
            ),
            UserData(
                arrayListOf(
                    PieEntry(77.4f),
                    PieEntry(61.2f),
                    PieEntry(41.6f),
                    PieEntry(3.3f),
                    PieEntry(39.0f)
                )
            )
        )
        for (scr in scoresList) {
            var totalScore = 0.0f
            for (score in scr.scores) {
                totalScore += score.value
            }
            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.FLOOR
            scr.totalCgpa = df.format(totalScore / 5).toFloat()
        }
        setPieChartData(scoresList[0])
        binding.forward.setOnClickListener {
            if (count >= 0 && count < scoresList.size) {
                setPieChartData(scoresList[count])
                count++
            }
            Log.i("forward count", count.toString())
        }
        binding.backward.setOnClickListener {
            if (count >= 0) {
                count--
                setPieChartData(scoresList[count])
            }
            Log.i("forward count", count.toString())
        }
    }

    private fun setPieChartData(scores: UserData) {
        val dataSet = PieDataSet(scores.scores, "Mobile OS")
        dataSet.setDrawIcons(false)
        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(0f, 40f)
        dataSet.selectionShift = 5f
        val colors: ArrayList<Int> = arrayListOf(
            Color.MAGENTA,
            Color.LTGRAY,
            Color.RED,
            Color.GREEN,
            Color.BLUE
        )
        dataSet.colors = colors
        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter())
        data.setValueTextSize(15f)
        data.setValueTypeface(Typeface.DEFAULT_BOLD)
        data.setValueTextColor(Color.WHITE)
        binding.pieChart.data = data
        binding.pieChart.animateY(1800, Easing.EaseInOutQuad)
        binding.pieChart.highlightValues(null)
        binding.pieChart.invalidate()
        binding.totalScore.text = scores.totalCgpa.toString() + "  CGPA" + " SEM-" + count
    }

}