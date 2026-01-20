package com.example.authpractice.service

import com.example.authpractice.view.login.Lmodel
import com.example.authpractice.view.register.Rmodel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface Authservice {

    fun register(rmodel: Rmodel): Task<AuthResult>

    fun login(lmodel: Lmodel): Task<AuthResult>

    fun usercreate(rmodel: Rmodel): Task<Void>

}