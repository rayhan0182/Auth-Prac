package com.example.authpractice.starter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.authpractice.R
import com.example.authpractice.bfragment.BaseFragment
import com.example.authpractice.databinding.FragmentStartBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint

class StartFragment : BaseFragment<FragmentStartBinding>(

    FragmentStartBinding::inflate

) {

    override fun usercreate() {

        autologin()


        with(binding){

            logIn.setOnClickListener {

                findNavController().navigate(R.id.action_startFragment_to_loginFragment)
            }

            signUp.setOnClickListener {

                findNavController().navigate(R.id.action_startFragment_to_regFragment)

            }


        }



    }

    private fun autologin() {

        FirebaseAuth.getInstance().currentUser?.let {

          findNavController().navigate(R.id.action_startFragment_to_dashFragment)

        }

    }

    override fun responsuser() {

    }


}