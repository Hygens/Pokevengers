package com.pokevengers.activities

import android.content.Intent
import android.os.Bundle

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.EditText
import com.pokevengers.R
import com.pokevengers.adapters.PokemonAdapter
import com.pokevengers.api.PokemonAPI
import com.pokevengers.api.PokemonAPIInt
import com.pokevengers.entities.Pokemon
import com.pokevengers.listeners.PokevengersTouchListener
import com.pokevengers.listeners.PokevengersTouchListener.ClickListener
import org.apache.commons.lang3.math.NumberUtils

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.jvm.java as java

class MainActivity : AppCompatActivity() {
    var pokemonList: MutableList<Pokemon?>? = ArrayList()
    var recyclerView: RecyclerView? = null
    var pokemonAdapter: PokemonAdapter? = null
    var search: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById<View?>(R.id.rvpokevengers) as RecyclerView
        pokemonAdapter = PokemonAdapter(pokemonList)
        val layoutManager: RecyclerView.LayoutManager
        layoutManager = LinearLayoutManager(applicationContext)
        recyclerView!!.setLayoutManager(layoutManager)
        recyclerView!!.setItemAnimator(DefaultItemAnimator())
        recyclerView!!.setAdapter(pokemonAdapter)
        addData()
        recyclerView!!.addOnItemTouchListener(PokevengersTouchListener(applicationContext, recyclerView, object : ClickListener {
            override fun onClick(view: View?, position: Int) {
                val i = Intent(this@MainActivity, DetailActivity::class.java)
                i.putExtra("pokemon", pokemonList?.get(position))
                startActivity(i)
            }

            override fun onLongClick(view: View?, position: Int) {}
        }))
        search = findViewById<View?>(R.id.searchEditText) as EditText
    }

    private fun addData() {
        val rnd = Random()
        for (i in 1..40) {
            apiCall(rnd.nextInt(807).toString())
        }
    }

    fun searchPokemon(view: View?) {
        val inp: String = search?.getText().toString()
        apiCall(inp);
    }

    fun apiCall(inp: String) {
        val apiService = PokemonAPI.getAPIClient()?.create(PokemonAPIInt::class.java)
        pokemonList?.clear()
        pokemonAdapter?.notifyDataSetChanged()
        if (!inp.isEmpty()) {
            val call: Call<Pokemon?>?
            if (NumberUtils.isCreatable(inp)) call = apiService?.getPokemon(inp.toInt()) else call = apiService?.getPokemon(inp)
            call?.enqueue(object : Callback<Pokemon?> {
                override fun onResponse(call: Call<Pokemon?>?, response: Response<Pokemon?>?) {
                    if (response?.isSuccessful()!!) {
                        val pokemon = response?.body()
                        pokemonList?.add(pokemon)
                        pokemonAdapter?.notifyDataSetChanged()

                        if (pokemon?.getPokeSlotTypes()?.size!! > 1) {
                            Log.i("POKEMON", "Type 1: " + pokemon?.getPokeSlotTypes()?.get(1)?.getPokeType()?.getName())
                        }
                    }
                }
                override fun onFailure(call: Call<Pokemon?>?, t: Throwable?) {
                    Log.e(">>>>>>>>>>>>> ERROR >>>>>>>>>>>>\n", t?.getLocalizedMessage().toString())
                }
            })
        } else {
            addData()
        }
    }
}