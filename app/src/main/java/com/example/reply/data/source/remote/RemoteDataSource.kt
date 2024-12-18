package com.example.reply.data.source.remote

import com.example.reply.data.model.Account
import com.example.reply.data.model.Email
import com.example.reply.data.source.AppDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiInterfaceLocal: ApiInterfaceLocal,
    private val apiInterface: ApiInterface
) : AppDataSource.Remote {
    override suspend fun getEmails(): ArrayList<Email> {
        return apiInterfaceLocal.getEmails()
    }

    override suspend fun getAccounts(): ArrayList<Account> {
        return apiInterfaceLocal.getAccounts()
    }
}