package com.example.pokemonapiintegration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation


class NavFrag : Fragment() {
    lateinit var logoutNavBtn:Button
    lateinit var searchPokemonNavBtn:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_nav, container, false)

        logoutNavBtn = view.findViewById(R.id.navLogoutBtn)
        searchPokemonNavBtn = view.findViewById(R.id.navSearchPokemonBtn)

        logoutNavBtn.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.goFormNavigationToLogout)
        }
        searchPokemonNavBtn.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.goFromNavigationToPokemon)
        }

        return view
    }


}