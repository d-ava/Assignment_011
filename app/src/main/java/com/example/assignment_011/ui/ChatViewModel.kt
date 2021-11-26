package com.example.assignment_011.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment_011.model.Item
import com.example.assignment_011.repository.ChatRepository
import com.example.assignment_011.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val repository: ChatRepository,

) : ViewModel() {

    private val _chat = MutableSharedFlow<Resource<Item>>()
    var chat: SharedFlow<Resource<Item>> = _chat

    fun loadChat(){
        Log.d("message", "from viewmodel loadChat()")
        viewModelScope.launch {
            repository.getChatItems().onEach {
                Log.d("message", "from viewmodel getchatitems onEach")
                Log.d("message", it.message!!)
                _chat.emit(it)
            }
        }
    }

}