package com.example.reply.ui.components

import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.reply.data.model.Email

@ExperimentalMaterial3Api
@Composable
fun ReplyDockedSearchBar(
    emails: List<Email>,
    onSearchItemSelected: (Email) -> Unit,
    modifier: Modifier = Modifier
) {
    var query by remember { mutableStateOf("") }

    var expanded by remember { mutableStateOf(false) }

    val searchResult = remember { mutableStateListOf<Email>() }

    val onExpandedChange: (Boolean) -> Unit = {
        expanded = it
    }

    LaunchedEffect(query) {
        searchResult.clear()
        if (query.isNotEmpty()) {
            searchResult.addAll(emails.filter {
                it.subject.startsWith(prefix = query, ignoreCase = true)
                        || it.sender.firstName.startsWith(
                    prefix = query, ignoreCase = true
                )
            })
        }
    }



    

}