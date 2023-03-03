package com.matech.kotlindsl

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationBarView
import com.matech.kotlindsl.databinding.ActivityBottomNavigationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomNavigationActivity : AppCompatActivity(),
    NavController.OnDestinationChangedListener/* NavigationBarView.OnItemSelectedListener */
   /* NavController.OnDestinationChangedListener*/ {

    private lateinit var binding: ActivityBottomNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val navView: BottomNavigationView = binding.navView
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_bottom_navigation) as NavHostFragment

        val navController = navHostFragment.navController
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            ),
            fallbackOnNavigateUpListener = ::onSupportNavigateUp
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
      //  navController.addOnDestinationChangedListener(this)
        // navView.setOnItemSelectedListener(this)
        val badge = binding.navView.getOrCreateBadge(binding.navView.menu[2].itemId)
        badge.isVisible = true
// An icon only badge will be displayed unless a number is set:
        badge.number = 99
        navController.addOnDestinationChangedListener(this)

    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
       binding.toolBarTitle.text = controller.previousBackStackEntry?.destination?.label
    }


    /* override fun onNavigationItemSelected(item: MenuItem): Boolean {
         if(item.itemId!= R.id.navigation_notifications){
             setSupportActionBar(binding.toolbar)

         }
         when (item.itemId){
             R.id.navigation_notifications->{
                 val badgeDrawable = binding.navView.getBadge(item.itemId)
                 badgeDrawable?.let {
                     badgeDrawable.isVisible = false
                     badgeDrawable.clearNumber()
                     findNavController(binding.root.id).navigate(R.id.navigation_notifications)

             }
                 binding.navView
             binding.navView.removeBadge(item.itemId)


             }
         }

         return true
     }*/
}