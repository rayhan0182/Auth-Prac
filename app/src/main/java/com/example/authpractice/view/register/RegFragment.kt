package com.example.authpractice.view.register

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
import com.example.authpractice.databinding.FragmentRegBinding
import com.example.authpractice.isemptyy
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegFragment : BaseFragment<FragmentRegBinding>(

    FragmentRegBinding::inflate

) {

    private val viewmod: ModelView by viewModels()

    override fun responsuser() {

        viewmod.registerrespons.observe(viewLifecycleOwner) {

           when(it){
               is DataState.Failure ->{

                   loadingbar.dismiss()

                   Toast.makeText(context, it.massage.toString(), Toast.LENGTH_LONG).show()

               }
               is DataState.Loading-> {

                   Toast.makeText(context,"Loading...", Toast.LENGTH_LONG).show()

               }
               is DataState.Success->{

                   loadingbar.dismiss()

                   Toast.makeText(context,"Successfully created:${it.utype}", Toast.LENGTH_LONG).show()

               }
           }


        }


    }

    override fun usercreate() {

        with(binding) {

            regBtn.setOnClickListener {

                name.isemptyy()

                email.isemptyy()

                pass.isemptyy()

                if (!name.isemptyy() && !email.isemptyy() && !pass.isemptyy()) {

                    val user = Rmodel(
                        name.text.toString(),

                        email.text.toString(), pass.text.toString(), "", "seller"

                    )

                    viewmod.mregister(user)

                    loadingbar.show()

                }


            }


        }


    }


}