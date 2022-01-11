package com.manhhung.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.manhhung.movie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentNavHost) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.dialogExoFullscreen -> binding.bottomNavigation.visibility = View.GONE
                R.id.loginFragment -> binding.bottomNavigation.visibility = View.GONE
                R.id.registerFragment -> binding.bottomNavigation.visibility = View.GONE
                else -> binding.bottomNavigation.visibility = View.VISIBLE
            }
        }
    }

    private fun showDialogExitApp() {
        AlertDialog.Builder(this)
            .setMessage("Bạn có muốn thoát ứng dụng không?")
            .setCancelable(false)
            .setPositiveButton("Có") { _, _ ->
                finish()
            }
            .setNegativeButton("Không") { _, _ ->
                null
            }.show()
    }

    override fun onBackPressed() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentNavHost) as NavHostFragment
        val navController = navHostFragment.navController
        if (navController.currentDestination?.id == R.id.homeFragment||navController.currentDestination?.id == R.id.loginFragment) {
            showDialogExitApp()
        } else {
            super.onBackPressed()
        }
    }
}
