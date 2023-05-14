package com.example.educationmanagementsystem.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.educationmanagementsystem.adapter.LibraryAdapter
import com.example.educationmanagementsystem.databinding.FragmentLibraryBinding
import com.example.educationmanagementsystem.models.BookData

class LibraryFragment : Fragment() {
    private lateinit var binding: FragmentLibraryBinding
    private lateinit var libraryAdapter: LibraryAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLibraryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        libraryAdapter = LibraryAdapter(activity)
        binding.back.setOnClickListener {
            activity?.onBackPressed()
        }
        libraryAdapter.bookList =
            arrayListOf(
                BookData("Design of Machine Elements", "Dr. R K Bansal", "https://research.nhm.org/pdfs/10592/10592.pdf", 452),
                BookData("A Textbook of Machine Design", "R S Khurmi & J K Gupta", "https://research.nhm.org/pdfs/10592/10592.pdf", 422),
                BookData("Theory of Machines", "R S Khurmi & J K Gupta", "https://research.nhm.org/pdfs/10592/10592.pdf", 769),
                BookData("The Feynman Lectures on Physics:\n" +
                        "Mainly Mechanics, Radiation and\n" +
                        "Heat – Vol. 1", "Richard Feynman,\n" +
                        "Robert Leighton &\n" +
                        "Mathew Sands", "https://research.nhm.org/pdfs/10592/10592.pdf", 112),
                BookData("An Introduction to Mechanics", "David Kleppner &\n" +
                        "Robert Kolenkow", "https://research.nhm.org/pdfs/10592/10592.pdf", 220),
                BookData("Essential Engineering Mechanics:\n" +
                        "with Simplified Integrated Methods\n" +
                        "of Solution", "Narasimha Siddhanti\n" +
                        "Malladi", "https://research.nhm.org/pdfs/10592/10592.pdf", 452),
                BookData("Mechanical Vibrations", "G K Grover", "https://research.nhm.org/pdfs/10592/10592.pdf", 1190),
                BookData("\tBasic & Applied Thermodynamics", "P K Nag", "https://research.nhm.org/pdfs/10592/10592.pdf", 292),
                BookData("Strength Of Materials Part 1\n" +
                        "Elementary Theory and Problems", "Stephen Timoshenko", "https://research.nhm.org/pdfs/10592/10592.pdf", 680),
                BookData("Production Technology: Manufacturing\n" +
                        "Processes, Technology and Automation", "Er R. K. Jain", "https://research.nhm.org/pdfs/10592/10592.pdf", 666),
                BookData("Fluid Mechanics", "Munsun, Okiishi,\n" +
                        "Huebsch & Rothmayer", "https://research.nhm.org/pdfs/10592/10592.pdf", 557),

                )
        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        binding.libraryRv.layoutManager = GridLayoutManager(activity, 1)
        binding.libraryRv.adapter = libraryAdapter
    }

}