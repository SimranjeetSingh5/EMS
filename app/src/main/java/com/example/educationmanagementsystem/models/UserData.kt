package com.example.educationmanagementsystem.models

import com.github.mikephil.charting.data.PieEntry

data class UserData(
    val scores: ArrayList<PieEntry> = arrayListOf(
        PieEntry(92.4f),
        PieEntry(41.2f),
        PieEntry(43.6f),
        PieEntry(33.3f),
        PieEntry(3.0f)
    ),
    var totalCgpa: Float = 0.0f
)
