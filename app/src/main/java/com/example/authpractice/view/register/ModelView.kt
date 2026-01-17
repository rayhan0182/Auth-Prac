package com.example.authpractice.view.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.authpractice.core.DataState
import com.example.authpractice.service.AuthRepo
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel


class ModelView: ViewModel() {

    private val _registerrespons = MutableLiveData<DataState<Rmodel>>()

    val registerrespons: LiveData<DataState<Rmodel>> = _registerrespons

    val repository = AuthRepo()

    fun mregister(rmodel: Rmodel){

        _registerrespons.postValue(DataState.Loading())

        repository.register(rmodel).addOnSuccessListener {

         _registerrespons.postValue(DataState.Success(rmodel))


        }.addOnFailureListener {exception ->

            _registerrespons.postValue(DataState.Failure(exception.message.toString()))

        }

    }

}