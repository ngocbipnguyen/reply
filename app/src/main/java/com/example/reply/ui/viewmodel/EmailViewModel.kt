package com.example.reply.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reply.data.model.Email
import com.example.reply.data.repository.ReplyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// Represents different states for the LatestNews screen
sealed class EmailUiState {
    data class Success(val news: List<Email>): EmailUiState()
    data object Loading: EmailUiState()
    data class Error(val exception: Throwable): EmailUiState()
}
@HiltViewModel
class EmailViewModel @Inject constructor(replyRepository: ReplyRepository) : ViewModel() {

    private var _emailState = MutableStateFlow(EmailUiState.Success(emptyList()))
    val emailState : StateFlow<EmailUiState> = _emailState


    init {
        viewModelScope.launch {
            val emails = replyRepository.getEmails()
            _emailState.value = EmailUiState.Success(emails)
        }
    }


}