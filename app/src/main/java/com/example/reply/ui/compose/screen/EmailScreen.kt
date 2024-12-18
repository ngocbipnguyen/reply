package com.example.reply.ui.compose.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.reply.ui.viewmodel.EmailViewModel

@Composable
fun EmailScreen(modifier: Modifier, viewModel : EmailViewModel = hiltViewModel()) {

    val uiState = viewModel.emailState.collectAsStateWithLifecycle()


}

@Composable
fun EmailPage() {

}