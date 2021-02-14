package com.example.navigation

import androidx.navigation.NavController
import com.example.core.navigation.AddItemTaskNavigator
import com.example.main.R
import javax.inject.Inject

class AddItemTaskNavigatorImpl @Inject constructor() : AddItemTaskNavigator{
    override fun navigateToListTask(navController: NavController) {
        navController.navigate(R.id.action_addItemFragment_to_taskFragment)
    }

}