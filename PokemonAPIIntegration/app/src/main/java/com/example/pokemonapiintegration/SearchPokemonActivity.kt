package com.example.pokemonapiintegration

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class SearchPokemonActivity : AppCompatActivity() {
    lateinit var js:JSONObject
    lateinit var searchView:TextView
    lateinit var searchBtn:Button
    lateinit var pokemonInfoLayout:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search_pokemon)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        searchView = findViewById(R.id.searchView)
        searchBtn = findViewById(R.id.searchBtn)
        pokemonInfoLayout = findViewById(R.id.pokemonInfoLayout)


        searchBtn.setOnClickListener{
            var baseUrl  = "https://pokeapi.co/api/v2/pokemon/"
            var completeUrl:String = baseUrl + searchView.text.toString().lowercase() + "/"
            Log.i("Sam", completeUrl)
        }
        var requestQueue: RequestQueue = Volley.newRequestQueue(this)
        var url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png"
        var imgView:ImageView = findViewById(R.id.pokemonImage)
        val params: ViewGroup.LayoutParams = imgView.layoutParams
        params.width = 400
        params.height = 400
        var imgreq= ImageRequest(url, {
                res->  imgView.setImageBitmap(res)
        },1000,1000, ImageView.ScaleType.FIT_END, Bitmap.Config.RGB_565,{})

        requestQueue.add(imgreq)
        //requestQueue.start()

        val dynamicName = TextView(this)
        val dynamicMove = TextView(this)
        val dynamicType = TextView(this)
        dynamicName.text = "Name:"
        dynamicMove.text = "Move:"
        dynamicType.text = "Type:"
        pokemonInfoLayout.addView(dynamicName)
        pokemonInfoLayout.addView(dynamicMove)
        pokemonInfoLayout.addView(dynamicType)

    }

    fun search(url:String){
        val rq:RequestQueue = Volley.newRequestQueue(this)
        val request:StringRequest = StringRequest(Request.Method.GET,url,{res ->
            js = JSONObject(res)
            }, {err -> Log.e("Sam", err.toString()) }
        )
        rq.add(request)
    }

}