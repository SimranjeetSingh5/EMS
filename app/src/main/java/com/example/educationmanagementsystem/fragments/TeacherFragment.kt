package com.example.educationmanagementsystem.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.educationmanagementsystem.databinding.FragmentTeacherBinding

class TeacherFragment : Fragment() {
    private lateinit var binding: FragmentTeacherBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeacherBinding.inflate(layoutInflater, container, false)
        when (this.arguments?.getString("Identifier")) {
            "cs" -> {
                binding.Hod.text = "HOD\nBaswaraj Gaikwad"
                binding.professor1.text = "Professor\nPrajakta Shinde"
                binding.professor2.text = "Professor\nAmar Raj Singh"
                binding.assistant.text = "Assistant Professor\nP.V. Laksman"
            }
            "it" -> {
                binding.Hod.text = "HOD\nShailesh Nag"
                binding.professor1.text = "Professor\nMonica Dsouza"
                binding.assistant.text = "Assistant Professor\nTeja Rao"
                binding.assistant.text = "Assistant Professor\nR Madhavan"
            }
            "eee" -> {
                binding.Hod.text = "HOD\nRajashekhar Mishra"
                binding.professor1.text = "Professor\nRammohan kumar"
                binding.professor2.text = "Professor\nDilmeet Malhotra"
                binding.assistant.text = "Assistant Professor\nKripal Singh"
            }
            else -> {
                binding.Hod.text = "HOD\nTapeshwar pujara"
                binding.professor1.text = "Professor\nMonty Gupta"
                binding.professor2.text = "Professor\nShalu Nair"
                binding.assistant.text = "Assistant Professor\nPintu Jaydev"
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bckBtn.setOnClickListener {
            fragmentManager?.popBackStack()
        }

    }

}