package com.example.authpractice.view.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.authpractice.R
import com.example.authpractice.bfragment.BaseFragment
import com.example.authpractice.core.DataState
import com.example.authpractice.databinding.FragmentLoginBinding
import com.example.authpractice.isemptyy
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(

    FragmentLoginBinding::inflate

){

    private val viewmodel: LViewmodel by viewModels()


    override fun responsuser() {

        viewmodel.loginmutablelivedata.observe(viewLifecycleOwner){

            when(it){
                is DataState.Failure -> {

                    loadingbar.dismiss()

                    Toast.makeText(context,"Failure:$it", Toast.LENGTH_LONG).show()

                }
                is DataState.Loading-> {

                    Toast.makeText(context,"Loading...", Toast.LENGTH_LONG).show()
                }
                is DataState.Success-> {

                    loadingbar.dismiss()

                    Toast.makeText(context,"Success done:${it.utype}", Toast.LENGTH_LONG).show()

                }
            }


        }



    }

    override fun usercreate() {

         with(binding){


             clickSave.setOnClickListener {

                 email.isemptyy()

                 pass.isemptyy()

                 if (!email.isemptyy()&&!pass.isemptyy()){

                     val user = Lmodel(email.text.toString(),pass.text.toString())

                     viewmodel.logincreate(user)

                     loadingbar.show()

                 }


             }



         }





    }


}