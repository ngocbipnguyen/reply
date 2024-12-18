package com.example.reply.data.source

import com.example.reply.data.model.Account
import com.example.reply.data.model.Email

interface AppDataSource {

    interface Remote {
        suspend fun getEmails(): ArrayList<Email>

        suspend fun getAccounts(): ArrayList<Account>
    }
}