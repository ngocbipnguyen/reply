package com.example.reply.data.repository

import com.example.reply.data.model.Account
import com.example.reply.data.model.Email
import com.example.reply.data.source.remote.RemoteDataSource
import javax.inject.Inject

class ReplyRepository @Inject constructor(val remoteDataSource: RemoteDataSource) {
    suspend fun getEmails(): ArrayList<Email> {
        return remoteDataSource.getEmails()
    }


    suspend fun getAccount(): ArrayList<Account> {
        return remoteDataSource.getAccounts()
    }
}