package com.matech.kotlindsl.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.matech.kotlindsl.R
import com.matech.kotlindsl.databinding.FragmentNotificationsBinding
import com.matech.kotlindsl.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val notificationsViewModel by viewModels<NotificationsViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.title
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        textView.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_notifications_to_testingFragment2)
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      //  val toolbar = (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)

        // Set the Toolbar as the Fragment's ActionBar


        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {

        // Set the activity's toolbar as the support action bar
        super.onDestroyView()
        _binding = null
    }
}