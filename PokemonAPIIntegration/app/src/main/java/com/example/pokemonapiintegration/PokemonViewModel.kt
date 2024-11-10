package com.example.pokemonapiintegration

import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import com.squareup.picasso.Picasso
import org.json.JSONObject

class PokemonViewModel : ViewModel() {
     var types:String = "normal"
    var pokemonPictureUrl ="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
    var pokename:String = "Ditto"




}