package com.example.reply.ui.compose.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.reply.data.model.Email
import com.example.reply.ui.viewmodel.EmailUiState
import com.example.reply.ui.viewmodel.EmailViewModel
import kotlinx.coroutines.launch

@Composable
fun EmailScreen(modifier: Modifier = Modifier, viewModel: EmailViewModel = hiltViewModel()) {
    Scaffold { paddingValues ->
        EmailPage(viewModel, modifier.padding(paddingValues))

    }
}

@Composable
fun EmailPage(viewModel: EmailViewModel, modifier: Modifier = Modifier) {
    val coroutines = rememberCoroutineScope()
//    Box(modifier = modifier.windowInsetsPadding(WindowInsets.statusBars)) {
//        LazyColumn(modifier = modifier
//            .fillMaxSize()
//            .padding(top = 80.dp),
//        ) {
//
//        }
//    }
    coroutines.launch {
        viewModel.emailState.collect { uiState ->
            when (uiState) {
                is EmailUiState.Success -> {

                }

                is EmailUiState.Loading -> {

                }

                is EmailUiState.Error -> {

                }
            }
        }
    }

}

@Composable
fun ListEmail(success: EmailUiState.Success, modifier: Modifier = Modifier) {
    Box(modifier = modifier.windowInsetsPadding(WindowInsets.statusBars)) {
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(top = 80.dp),
        ) {
            itemsIndexed(success.news) { index, email ->


            }
        }
    }
}

@Composable
fun ItemEmail(
    email: Email,
    modifier: Modifier,
    isOpened: Boolean = false,
    isSelected: Boolean = false,
) {
    Card(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clip(CardDefaults.shape)
            .clip(CardDefaults.shape),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.primaryContainer
            else if (isOpened) MaterialTheme.colorScheme.secondaryContainer
            else MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    modifier = modifier
                        .size(40.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = email.sender.avatar),
                    contentDescription = email.sender.firstName,
                )

                Column(
                    modifier
                        .weight(1f)
                        .padding(horizontal = 12.dp, vertical = 4.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = email.sender.firstName,
                        style = MaterialTheme.typography.labelMedium
                    )
                    Text(text = email.createdAt, style = MaterialTheme.typography.labelMedium)
                }

                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surfaceContainerHigh)
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Favorite",
                        tint = MaterialTheme.colorScheme.outline
                    )
                }
            }

            Text(
                text = email.subject,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 12.dp, bottom = 8.dp)
            )

            Text(
                text = email.body,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

        }
    }
}