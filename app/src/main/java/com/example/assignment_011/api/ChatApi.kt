package com.example.assignment_011.api

import com.example.assignment_011.BuildConfig.API_KEY
import com.example.assignment_011.model.Item
import retrofit2.Response
import retrofit2.http.GET

interface ChatApi {

    @GET(API_KEY)
    suspend fun getChat():Response<Item>

}