package com.example.reply

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ReplyApp() {
    val navigation = rememberNavController()
    ReplyNavHost(navigation)
}

@Composable
fun ReplyNavHost(navHost: NavHostController) {
    NavHost(navController = navHost, startDestination =  Screen.Email.route) {
        composable(route = Screen.Email.route) {

        }
        composable(route = Screen.Account.route) {

        }
    }
}