package com.matech.kotlindsl

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationBarView
import com.matech.kotlindsl.databinding.ActivityBottomNavigationBinding

class BottomNavigationActivity : AppCompatActivity()/*, NavigationBarView.OnItemSelectedListener */{

    private lateinit var binding: ActivityBottomNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_bottom_navigation)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
       // navView.setOnItemSelectedListener(this)
        val badge = binding.navView.getOrCreateBadge(binding.navView.menu[2].itemId)
        badge.isVisible = true
// An icon only badge will be displayed unless a number is set:
        badge.number = 99
    }

   /* override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.navigation_notifications->{
               *//* val badgeDrawable = binding.navView.getBadge(item.itemId)
                badgeDrawable?.let {
                    badgeDrawable.isVisible = false
                    badgeDrawable.clearNumber()

            }*//*
                binding.navView
            binding.navView.removeBadge(item.itemId)


            }
        }
        return false
    }*/
}