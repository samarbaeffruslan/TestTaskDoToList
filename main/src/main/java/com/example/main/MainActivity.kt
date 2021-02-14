package com.example.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.core_api.AppWithFacade
import com.example.di.MainComponent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        initDI()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment? ?: return

        host.navController

        findNavController(R.id.nav_host_fragment)
    }

    private fun initDI() {
        MainComponent.create((application as AppWithFacade).getFacade())
            .inject(this)
    }
}