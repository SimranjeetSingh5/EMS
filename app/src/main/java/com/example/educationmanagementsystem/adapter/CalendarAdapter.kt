package com.example.educationmanagementsystem.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.educationmanagementsystem.R
import com.example.educationmanagementsystem.utils.CalendarUtils
import java.time.LocalDate


internal class CalendarAdapter(days: ArrayList<LocalDate?>, onItemListener: OnItemListener) :
    RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder>() {
    private val days: ArrayList<LocalDate?>
    private val onItemListener: OnItemListener

    init {
        this.days = days
        this.onItemListener = onItemListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.calender_cell, parent, false)
        val layoutParams: ViewGroup.LayoutParams = view.layoutParams
        if (days.size > 15) //month view
            layoutParams.height = (parent.height * 0.166666666).toInt() else  // week view
            layoutParams.height = parent.height
        return CalendarViewHolder(view, onItemListener, days)
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        val date: LocalDate = days[position]!!
        holder.dayOfMonth.text = date.dayOfMonth.toString()
        if (date == CalendarUtils.selectedDate) holder.parentView.setBackgroundColor(Color.LTGRAY)
    }

    override fun getItemCount(): Int {
        return days.size
    }

    interface OnItemListener {
        fun onItemClick(position: Int, date: LocalDate?)
    }

    inner class CalendarViewHolder(
        itemView: View,
        onItemListener: OnItemListener,
        days: ArrayList<LocalDate?>
    ) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val days: ArrayList<LocalDate?>
        val parentView: View
        val dayOfMonth: TextView
        private val onItemListener: OnItemListener

        init {
            parentView = itemView.findViewById(R.id.parentView)
            dayOfMonth = itemView.findViewById(R.id.cellDayText)
            this.onItemListener = onItemListener
            itemView.setOnClickListener(this)
            this.days = days
        }

        override fun onClick(view: View?) {
            onItemListener.onItemClick(adapterPosition, days[adapterPosition])
        }
    }
}