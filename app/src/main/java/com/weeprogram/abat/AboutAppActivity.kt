package com.weeprogram.abat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.weeprogram.abat.databinding.ActivityAboutAppBinding
import com.weeprogram.abat.databinding.ActivityMainBinding

class AboutAppActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityAboutAppBinding>(this, R.layout.activity_about_app)
        setContentView(binding.root)

        val navController = this.findNavController(R.id.myNavHostAboutFragment)
        drawerLayout = binding.drawerLayout
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        NavigationUI.setupWithNavController(binding.navView, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostAboutFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}