package com.example.pokemonapiintegration

import android.os.Bundle
import android.provider.DocumentsContract.Root
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment


lateinit var loginText:TextView
class LogInFrag : Fragment() {


lateinit var text:TextView
lateinit var btn:Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_log_in, container, false)



        text = view.findViewById(R.id.userEmail)
        text.text = "HJOLP"
        btn = view.findViewById(R.id.btnLogin)
        btn.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.goFromLoginToNavigation)
            
        }


        return view

    }


}