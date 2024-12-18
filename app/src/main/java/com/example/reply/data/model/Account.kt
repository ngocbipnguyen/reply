package com.example.reply.data.model

data class Account(
    val id: Long,
    val uid: Long,
    val firstName: String,
    val lastName: String,
    val email: String,
    val altEmail: String,
    val avatar: String,
    var isCurrentAccount: Boolean = false,
    var token: String = ""
)
