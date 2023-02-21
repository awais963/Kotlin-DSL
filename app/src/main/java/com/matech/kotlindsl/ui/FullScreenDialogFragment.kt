package com.matech.kotlindsl.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.google.android.material.textview.MaterialTextView
import com.matech.kotlindsl.R
import com.matech.kotlindsl.databinding.FragmentFullScreenDialogBinding
import com.matech.kotlindsl.databinding.FragmentHomeBinding


class FullScreenDialogFragment : DialogFragment() {


    private var _binding: FragmentFullScreenDialogBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFullScreenDialogBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
binding.bodyTv.setOnClickListener { dismiss() }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getTheme(): Int {
        return R.style.DialogTheme
    }

}