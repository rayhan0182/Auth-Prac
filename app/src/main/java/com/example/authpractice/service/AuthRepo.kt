package com.example.authpractice.service
import com.example.authpractice.Nodesvalue
import com.example.authpractice.view.login.Lmodel
import com.example.authpractice.view.register.Rmodel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class AuthRepo @Inject constructor(private val auth: FirebaseAuth,

    private val firestore: FirebaseFirestore

    ): Authservice {



    override fun register(rmodel: Rmodel): Task<AuthResult> {


        return auth.createUserWithEmailAndPassword(rmodel.email, rmodel.password)

    }

    override fun login(lmodel: Lmodel): Task<AuthResult> {

        return auth.signInWithEmailAndPassword(lmodel.email, lmodel.password)

    }

    override fun usercreate(rmodel: Rmodel): Task<Void> {

      return  firestore.collection(Nodesvalue.User).document(rmodel.userid).set(rmodel)

    }

    }


