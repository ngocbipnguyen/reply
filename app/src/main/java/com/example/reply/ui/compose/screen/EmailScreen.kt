package com.example.reply.ui.compose.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.reply.ui.viewmodel.EmailUiState
import com.example.reply.ui.viewmodel.EmailViewModel
import kotlinx.coroutines.launch

@Composable
fun EmailScreen(modifier: Modifier = Modifier, viewModel : EmailViewModel = hiltViewModel()) {
    Scaffold {
            paddingValues ->
        EmailPage(viewModel, modifier.padding(paddingValues))

    }
}

@Composable
fun EmailPage(viewModel : EmailViewModel, modifier: Modifier = Modifier) {
    val coroutines = rememberCoroutineScope()
    Box(modifier = modifier.windowInsetsPadding(WindowInsets.statusBars)) {
        LazyColumn(modifier = modifier
            .fillMaxSize()
            .padding(top = 80.dp),
        ) {

        }
    }
    coroutines.launch {
        viewModel.emailState.collect{ uiState ->
            when(uiState) {
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