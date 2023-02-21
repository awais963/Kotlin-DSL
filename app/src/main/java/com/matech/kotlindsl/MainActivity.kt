package com.matech.kotlindsl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.matech.kotlindsl.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.apply {
            tvMessage.text= BuildConfig.TEST_STRING
            tvMessage.setOnClickListener {
                    startActivity(Intent(this@MainActivity,BottomNavigationActivity::class.java))
            }
        }


    }
}