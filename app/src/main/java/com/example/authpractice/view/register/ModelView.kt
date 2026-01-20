package com.example.authpractice.view.register
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.authpractice.core.DataState
import com.example.authpractice.service.AuthRepo
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ModelView @Inject constructor(private val repo: AuthRepo,


    ): ViewModel() {

    private val _registerrespons = MutableLiveData<DataState<Rmodel>>()

    val registerrespons: LiveData<DataState<Rmodel>> = _registerrespons


    fun mregister(rmodel: Rmodel) {

        _registerrespons.postValue(DataState.Loading())

        repo.register(rmodel).addOnSuccessListener {

          it.user?.let { usercreated->

              rmodel.userid = usercreated.uid

              repo.usercreate(rmodel).addOnSuccessListener {

                  _registerrespons.postValue(DataState.Success(rmodel))

              }.addOnFailureListener {exception ->

                  _registerrespons.postValue(DataState.Massage(exception.message.toString()))

              }

          }


        }.addOnFailureListener { exception ->

            _registerrespons.postValue(DataState.Massage(exception.message.toString()))

        }

    }

}