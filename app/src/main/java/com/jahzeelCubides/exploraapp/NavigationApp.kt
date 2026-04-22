package com.jahzeelCubides.exploraapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationApp() {
    val myNavController = rememberNavController()

    NavHost(
        navController = myNavController,
        startDestination = "login",
        modifier = Modifier.fillMaxSize()
    ) {
        composable(route = "login") {
            LoginScreen(
                onNavigateToRegister = {
                    myNavController.navigate(route = "register")
                }, onLoginSuccess = {
                    myNavController.navigate("home")
                }
            )
        }

        composable(route = "register") {
            RegisterScreen(
                onRegisterSuccess = {},
                onNavigateToLogin = {},
                onBackClick = {
                    myNavController.navigate(route = "login")
                }
            )
        }

        composable("home") {
            HomeScreen()
        }
    }
}