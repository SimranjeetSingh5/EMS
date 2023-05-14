package com.example.educationmanagementsystem.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.educationmanagementsystem.databinding.ItemFeesBinding
import com.example.educationmanagementsystem.models.FeeData

class FeesAdapter : RecyclerView.Adapter<FeesAdapter.MyViewHolder>() {
    var feesList: ArrayList<FeeData> = arrayListOf()

    class MyViewHolder(val binding: ItemFeesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemFeesBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val feeItem = feesList[position]
        val feeHolder: MyViewHolder = holder
        feeHolder.binding.amount.text = feeItem.amount.toString()
        feeHolder.binding.bankDate.text = feeItem.bankDate
        feeHolder.binding.bankRef.text = feeItem.bankRefNo
        feeHolder.binding.studentId.text = feeItem.studentId
        feeHolder.binding.voucherNo.text = feeItem.voucherNo

    }

    override fun getItemCount(): Int {
        return feesList.size
    }

}