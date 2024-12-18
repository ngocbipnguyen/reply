package com.example.reply

import androidx.navigation.NamedNavArgument

sealed class Screen(val route: String, val argument: List<NamedNavArgument> = emptyList()) {
    object Email: Screen("Email")

    object Account: Screen("Account")
}