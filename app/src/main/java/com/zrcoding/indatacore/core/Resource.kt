package com.zrcoding.indatacore.core

sealed class Resource<T> {
    class Loading<T>(val data: T? = null) : Resource<T>()
    class Success<T>(val data: T) : Resource<T>()
    class Error<T>(val exception: Exception) : Resource<T>()
}