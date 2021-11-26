package com.example.assignment_011

import com.example.assignment_011.model.Item



sealed class Resource2{
    object Loading: Resource2()
    class Error(val text:Throwable) : Resource2()
    class Success(val data: List<Item>) : Resource2()
    object Empty: Resource2()
}