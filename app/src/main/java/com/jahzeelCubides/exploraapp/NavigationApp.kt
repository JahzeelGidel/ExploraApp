package com.jahzeelCubides.exploraapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.jahzeelCubides.exploraapp.ui.elements.AddTouristicPlaceScreen
import com.jahzeelCubides.exploraapp.ui.elements.HomeScreen
import com.jahzeelCubides.exploraapp.ui.elements.LoginScreen
import com.jahzeelCubides.exploraapp.ui.elements.RegisterScreen

@Composable
fun NavigationApp() {
    val auth = Firebase.auth
    val currentUser = auth.currentUser
    val startDestination = if (currentUser != null) "home" else "login"

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier.fillMaxSize()
    ) {


        composable(route = "register") {
            RegisterScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onRegisterSuccess = {
                    navController.navigate(route = "home") {
                        popUpTo(id = 0) { inclusive = true }
                    }
                }
            )
        }

        composable(route = "login") {
            LoginScreen(onLoginSuccess = {}, onNavigateToRegister = {
                navController.navigate("register")
            })
        }

        composable(route = "home") {
            HomeScreen(
                onClickLogout = {
                    navController.navigate(route = "login") {
                        popUpTo(id = 0) { inclusive = true }
                    }
                })
        }
        composable(route = "AddTouristicPlaceScreen") {
            AddTouristicPlaceScreen()
        }
    }
}





