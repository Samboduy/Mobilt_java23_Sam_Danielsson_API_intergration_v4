package com.example.pokemonapiintegration

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Picasso
import org.json.JSONObject

class PokemonFrag : Fragment() {

    lateinit var searchView:TextView
    lateinit var searchBtn:Button
    lateinit var pokemonSoundBtn:Button
    lateinit var typesView:TextView
    lateinit var nameView:TextView
    lateinit var jsonObject:JSONObject
    lateinit var types:String
    lateinit var pokemonView:ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pokemon, container, false)

        val baseUrl = "https://pokeapi.co/api/v2/pokemon/"
        searchBtn = view.findViewById(R.id.pokemonSearchBtn)
        pokemonSoundBtn = view.findViewById(R.id.playPokemonSound)
        searchView = view.findViewById(R.id.searchPokemon)
        typesView = view.findViewById(R.id.pokemonTypes)
        nameView = view.findViewById(R.id.pokemonName)
        pokemonView = view.findViewById(R.id.pokemonPicture)

        searchBtn.setOnClickListener{
            pokemonSoundBtn.visibility = View.VISIBLE
            var searchText = searchView.text.toString().trim().lowercase()
            if (searchText.isNotEmpty()){
                var completeURL = baseUrl + searchText
                val rq: RequestQueue = Volley.newRequestQueue(activity)
                var request = StringRequest(Request.Method.GET,completeURL,
                    {
                        res -> jsonObject = JSONObject(res)
                        Log.i("Sam",jsonObject.toString())
                        var jsArr = jsonObject.getJSONArray("abilities")
                        var pokeName:String = jsonObject.getString("name")
                        nameView.text = "name: " +  pokeName
                        var abilityName = jsArr.getJSONObject(0)
                        Log.i("SAm", "ARRAY: " + jsArr[0].toString())
                        Log.i("Sam", "ability: " + abilityName.getJSONObject("ability").getString("name"))
                        getPokemonTypes()
                        typesView.text = "types: " + types
                        getPokemonSprite()

                    },{
                        e-> Log.e("Sam", e.toString())
                    })

                rq.add(request)
            }
        }

        pokemonSoundBtn.setOnClickListener{
            getPokemonSound()
        }

        return view
    }

    fun getPokemonTypes(){
        var typesArr = jsonObject.getJSONArray("types")
        types = "";
        for (i in 0 until typesArr.length()){
            types = types + typesArr.getJSONObject(i).getJSONObject("type").getString("name") + " "
            Log.i("Sam", types)
        }
        types.trim()
    }

    fun getPokemonSprite(){
        var pokemonSpriteObject:JSONObject = jsonObject.getJSONObject("sprites")
        val pokemonPictureUrl = pokemonSpriteObject.getString("front_default")
        Picasso.get().load(pokemonPictureUrl).resize(200,200).into(pokemonView)
    }

    fun getPokemonSound(){
        var player = MediaPlayer()
        var jsSoundUrl = jsonObject.getJSONObject("cries").getString("latest")
        context?.let { player.setDataSource(it,jsSoundUrl.toUri()) }
        player.prepare()
        player.start()
    }


}