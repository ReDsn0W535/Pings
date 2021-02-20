package com.production.navigation

sealed class NavigationFlow {
    object SettingsFlow : NavigationFlow()
    object DashboardFlow : NavigationFlow()
    object AddAlarmFlow : NavigationFlow()
}
