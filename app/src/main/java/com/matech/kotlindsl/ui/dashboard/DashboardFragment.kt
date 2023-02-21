package com.matech.kotlindsl.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.matech.kotlindsl.databinding.FragmentDashboardBinding
import com.matech.kotlindsl.ui.FullScreenDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel
            by viewModels<DashboardViewModel> ()

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        textView.setOnClickListener {
            showDialog()
        }
        return root
    }
    private fun showDialog() {
        val dialogFragment = FullScreenDialogFragment()
        dialogFragment.show(childFragmentManager, "signature")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}