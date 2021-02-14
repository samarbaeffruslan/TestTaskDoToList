package com.example.navigation

import androidx.navigation.NavController
import com.example.core.navigation.TaskListNavigator
import com.example.main.R
import javax.inject.Inject

class TaskListNavigatorImpl @Inject constructor(): TaskListNavigator {

    override fun navigateToAddItemTask(navController: NavController) {
        navController.navigate(R.id.action_taskFragment_to_addItemFragment)
    }
}