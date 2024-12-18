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

data class ReplyHomeUIState(
    val emails: List<Email> = emptyList(),
    val selectedEmail: Email? = null,
    val isDetailOnlyOpen: Boolean = false,
    val loading: Boolean = false,
    val error: String? = null
)


@HiltViewModel
class EmailViewModel @Inject constructor(replyRepository: ReplyRepository) : ViewModel() {

    private var _emailState = MutableStateFlow(ReplyHomeUIState(loading = true))
    val emailState : StateFlow<ReplyHomeUIState> = _emailState


    init {
        viewModelScope.launch {
            val emails = replyRepository.getEmails()
            _emailState.value = _emailState.value.copy(
                emails = emails,
                selectedEmail = emails.first()
            )
        }
    }


}