package com.example.authpractice

import android.widget.EditText

fun EditText.isemptyy(): Boolean{

  return  if (this.text.isEmpty()){

        this.error = "plz fillup"

        true

    }else{

        false

    }


}