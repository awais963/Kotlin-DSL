package com.matech.kotlindsl.ui.home

import android.os.Bundle
import android.security.keystore.KeyProperties
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.matech.kotlindsl.CryptoManager
import com.matech.kotlindsl.databinding.FragmentHomeBinding
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.SecretKey

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val cryptoManager = CryptoManager()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onResume() {
        encryptionImplemented()
        super.onResume()
    }

    private fun encryptionImplemented() {
      try  {
            val message = "TEst"
            binding.textHome.text = "Before Encryption :$message"
          val file = File(requireContext().filesDir,"string.txt")
          if(!file.exists()){
              file.createNewFile()
          }
          val fos = FileOutputStream(file)
          val dec =cryptoManager.encrypt(message.encodeToByteArray(),fos)
            binding.textHome2.text = "After Encryption:${dec.decodeToString()}"
            binding.textHome3.text =
                "After Decryption " + cryptoManager.decrypt(FileInputStream(file)).decodeToString()
         /* binding.textHome3.text =
              "After Decryption " + cryptoManager.decrypt("as".toByteArray()).decodeToString()*/

        }
      catch (e:Exception){
          Log.e("CIPHER",e.message.toString())
      }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}