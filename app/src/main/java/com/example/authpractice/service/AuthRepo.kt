package com.example.authpractice.service

import com.example.authpractice.view.login.Lmodel
import com.example.authpractice.view.register.Rmodel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint


class AuthRepo: Authservice {

    val authins  = FirebaseAuth.getInstance()

    override fun register(rmodel: Rmodel): Task<AuthResult> {



       return authins.createUserWithEmailAndPassword(rmodel.email,rmodel.password)

    }

    override fun login(lmodel: Lmodel): Task<AuthResult> {

      return  authins.signInWithEmailAndPassword(lmodel.email,lmodel.password)

    }


}