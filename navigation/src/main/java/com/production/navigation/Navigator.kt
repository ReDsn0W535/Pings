package com.production.navigation

import androidx.navigation.NavController

class Navigator {
    lateinit var navController: NavController

    fun navigateToFlow(navigationFlow: NavigationFlow) = when (navigationFlow) {
        NavigationFlow.SettingsFlow -> navController.navigate(MainFlowDirections.actionGlobalSettingsFlow())
        NavigationFlow.DashboardFlow -> navController.navigate(MainFlowDirections.actionGlobalOverviewFlow())
    }
}