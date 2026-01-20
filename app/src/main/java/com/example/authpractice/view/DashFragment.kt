package com.example.authpractice.view

import androidx.navigation.fragment.findNavController
import com.example.authpractice.R
import com.example.authpractice.bfragment.BaseFragment
import com.example.authpractice.databinding.FragmentDashBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@AndroidEntryPoint
class DashFragment : BaseFragment<FragmentDashBinding>(

    FragmentDashBinding::inflate)

 {
    @Inject
    lateinit var jauth: FirebaseAuth

    override fun responsuser() {

    }

    override fun usercreate() {


        with(binding){

            logout.setOnClickListener {

                jauth.signOut()

                findNavController().navigate(R.id.action_dashFragment_to_startFragment)

            }


        }



    }


}