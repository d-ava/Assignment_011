package com.example.assignment_011.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment_011.repository.ChatRepository
import com.example.assignment_011.Resource
import com.example.assignment_011.Resource2
import com.example.assignment_011.api.ChatApi
import com.example.assignment_011.model.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val repository: ChatRepository,
    private val chatApi: ChatApi
) : ViewModel() {

//    private val _chat = MutableSharedFlow<Resource<Item>>()
//    var chat: SharedFlow<Resource<Item>> = _chat
//
//    fun loadChat(){
//        Log.d("message", "from viewmodel loadChat()")
//        viewModelScope.launch {
//            repository.getChatItems().onEach {
//
//                _chat.emit(it)
//            }.launchIn(this)
//        }
//    }

    /////////////////////////

    private val _chatSFlow:MutableStateFlow<Resource2> = MutableStateFlow(Resource2.Empty)
    val chatSFlow :StateFlow<Resource2> = _chatSFlow



    fun loadChat2(){
        viewModelScope.launch {
            repository.getChatItems2().catch {
                Log.d("message", "error 888888")
                _chatSFlow.value = Resource2.Error(it)
            }.collect(){
                _chatSFlow.value = Resource2.Success(it)
            }
        }
    }



}