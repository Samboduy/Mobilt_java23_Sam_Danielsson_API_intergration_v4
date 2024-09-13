package com.example.pokemonapiintegration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import kotlin.math.log

class LogOutFrag : Fragment() {
    private lateinit var logoutBtn:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view:View =  inflater.inflate(R.layout.fragment_log_out, container, false)

        logoutBtn = view.findViewById(R.id.logoutBtn)
        logoutBtn.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_logOutFrag_to_logInFrag2)

        }
        return view
    }


}