package com.example.authpractice.view.login
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.authpractice.core.DataState
import com.example.authpractice.service.AuthRepo
import dagger.hilt.android.lifecycle.HiltViewModel

import javax.inject.Inject


@HiltViewModel
class LViewmodel @Inject constructor(private val repo: AuthRepo): ViewModel() {

    private val _loginmutablelivedata = MutableLiveData<DataState<Lmodel>>()

    val loginmutablelivedata: LiveData<DataState<Lmodel>> = _loginmutablelivedata



    fun logincreate(lmodel: Lmodel){

        _loginmutablelivedata.postValue(DataState.Loading())


        repo.login(lmodel).addOnSuccessListener {

            _loginmutablelivedata.postValue(DataState.Success(lmodel))

        }.addOnFailureListener { exception ->

            _loginmutablelivedata.postValue(DataState.Massage(exception.message.toString()))

        }

    }


}