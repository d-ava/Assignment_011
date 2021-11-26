package com.example.assignment_011

import com.example.assignment_011.model.Item

sealed class Resource<out T>(
    val data: T? = null,
    val message: String? = null,
    val loading: Boolean = false,
   // val empty: T? = null

) {
    class Success<T>(data: T) : Resource<T>(data = data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(
        data = data,
        message = message
    )

    class Loading<T>(load: Boolean) : Resource<T>(loading = load)

}

