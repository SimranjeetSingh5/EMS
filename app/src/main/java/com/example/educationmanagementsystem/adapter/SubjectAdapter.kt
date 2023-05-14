package com.example.educationmanagementsystem.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.educationmanagementsystem.R
import com.example.educationmanagementsystem.databinding.ItemSubjectBinding
import com.example.educationmanagementsystem.models.SubjectData

class SubjectAdapter(private val ctx: Context) :
    RecyclerView.Adapter<SubjectAdapter.MyViewHolder>() {
    var subjectList: ArrayList<SubjectData> = arrayListOf()

    class MyViewHolder(val binding: ItemSubjectBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemSubjectBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val subjectItem = subjectList[position]
        val subjectHolder:MyViewHolder = holder as MyViewHolder
        subjectHolder.binding.subject.text = subjectItem.name
        subjectHolder.binding.isPresent.let {
            if (subjectItem.presentToday)
                it.setImageDrawable(ContextCompat.getDrawable(ctx, R.drawable.ic_round_check_circle_24))
            else
                it.setImageDrawable(ContextCompat.getDrawable(ctx, R.drawable.ic_absent))
        }
        subjectHolder.binding.totalAttendance.text = "Total Attendance:"+subjectItem.totalAtten +"/60"

    }

    override fun getItemCount(): Int {
        return subjectList.size
    }
}