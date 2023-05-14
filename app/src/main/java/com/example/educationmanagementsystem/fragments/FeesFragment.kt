package com.example.educationmanagementsystem.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.educationmanagementsystem.adapter.FeesAdapter
import com.example.educationmanagementsystem.databinding.FragmentFeesBinding
import com.example.educationmanagementsystem.models.FeeData


class FeesFragment : Fragment() {
    private lateinit var binding: FragmentFeesBinding

    private lateinit var feesAdapter: FeesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFeesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        feesAdapter = FeesAdapter()
        binding.back.setOnClickListener {
            activity?.onBackPressed()
        }
        feesAdapter.feesList = arrayListOf(
            FeeData("1819/VSC2/1241", "VSCW/2012/12414", "2021-02-07", "pay.JBFjbfihiNO", 10000),
            FeeData("1819/VSC2/1241", "VSCW/2012/12413", "2021-12-20", "pay.KBNImoaofNO", 45619),
            FeeData("1819/VSC2/1241", "VSCW/2012/12412", "2021-04-18", "pay.QPPRNjjjajp", 20151),
            FeeData("1819/VSC2/1241", "VSCW/2012/12411", "2021-06-08", "pay.IVOAjafkppp", 10000),
            FeeData("1819/VSC2/1241", "VSCW/2012/12410", "2021-01-27", "pay.OQNPQQJAaoo", 40000),
            FeeData("1819/VSC2/1241", "VSCW/2012/12409", "2021-06-07", "pay.ONAFQQMVHVH", -1510),
            FeeData("1819/VSC2/1241", "VSCW/2012/12408", "2021-02-05", "pay.ajbfjanbfia", 69000))
            val layoutManager =
        LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.feesRV.layoutManager = layoutManager
        binding.feesRV.adapter = feesAdapter
    }

}