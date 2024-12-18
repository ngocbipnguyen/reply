package com.example.reply.data.source.remote

import com.example.reply.data.model.Account
import com.example.reply.data.model.Email
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface ApiInterfaceLocal {

    @GET("email.json")
    suspend fun getEmails(): ArrayList<Email>

    @GET("account.json")
    suspend fun getAccounts(): ArrayList<Account>

}