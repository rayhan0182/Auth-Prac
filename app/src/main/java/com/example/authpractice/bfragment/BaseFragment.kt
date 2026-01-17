package com.example.authpractice.bfragment

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.AndroidEntryPoint


abstract class BaseFragment<VB: ViewBinding>(

    private val layoutinflate:(inflate: LayoutInflater)->VB

): Fragment() {

    private var _binding:VB? = null

    val binding:VB get() = _binding as VB

    lateinit var loadingbar: ProgressDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = layoutinflate.invoke(inflater)

        loadingbar = ProgressDialog(requireContext())

        usercreate()

        responsuser()

        return binding.root
    }

    abstract fun responsuser()

    abstract fun usercreate()


}