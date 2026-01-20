package com.example.authpractice.di

import com.example.authpractice.service.AuthRepo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Firemodule {


    @Provides
    @Singleton

    fun firebaseauthti(): FirebaseAuth{

       return FirebaseAuth.getInstance()

    }

    @Provides

    @Singleton

    fun authrepository(jauth: FirebaseAuth,firestore: FirebaseFirestore): AuthRepo{


       return AuthRepo(jauth,firestore)

    }

    @Provides

    @Singleton

    fun firebasefirestore(): FirebaseFirestore{

      return  FirebaseFirestore.getInstance()

    }



}