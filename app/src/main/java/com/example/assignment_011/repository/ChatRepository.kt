package com.example.assignment_011.repository

import android.util.Log
import com.example.assignment_011.api.ChatApi
import com.example.assignment_011.model.Item
import com.example.assignment_011.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ChatRepository @Inject constructor(private val chatApi: ChatApi) {

//    suspend fun getChatItems(): Flow<Resource<Item>> = flow {
//        try {
//            Log.d("message", "from repo getChatItems")
//            emit(Resource.Loading(true))
//            val response = chatApi.getChat()
//            val body = response.body()
//            if (response.isSuccessful && body != null) {
//                Log.d("message", "from repo getChatItems if response is succesful")
//                emit(Resource.Success(body))
//            } else {
//                Log.d("message", "from repo getChatItems error message")
//                emit(Resource.Error(response.message()))
//            }
//        } catch (e: Throwable) {
//            emit(Resource.Error(e.message ?: "some error message"))
//        }
//    }

    suspend fun getChatItems2(): Flow<List<Item>> = flow {
        val response = chatApi.getChat()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            emit(body)

        }
    }


}