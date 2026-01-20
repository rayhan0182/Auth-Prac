package com.example.authpractice.core

sealed class DataState<T>(

    val massage: String? = null,

    val utype: T? = null

) {

    class Loading<T>(): DataState<T>()

    class Success<T>(type:T): DataState<T>(utype = type)

    class Massage<T>(errormas: String): DataState<T>(massage = errormas)


}