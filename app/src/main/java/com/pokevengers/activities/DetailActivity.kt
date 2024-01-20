package com.pokevengers.activities

import android.os.Bundle

import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.pokevengers.R

import com.pokevengers.entities.Pokemon
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    private var tvName: TextView? = null
    private var tvTypes: TextView? = null
    private var tvAttack: TextView? = null
    private var tvDefense: TextView? = null
    private var tvSpeed: TextView? = null
    private var ivPokemon: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val pokemon = intent.getSerializableExtra("pokemon") as Pokemon
        val i = intent
        Toast.makeText(this@DetailActivity, pokemon.pokedexId.toString() + "", Toast.LENGTH_SHORT).show()
        tvName = findViewById<View?>(R.id.tv_detail_name) as TextView
        tvTypes = findViewById<View?>(R.id.tv_detail_types) as TextView
        tvAttack = findViewById<View?>(R.id.tv_detail_attack) as TextView
        tvDefense = findViewById<View?>(R.id.tv_detail_defense) as TextView
        tvSpeed = findViewById<View?>(R.id.tv_detail_speed) as TextView
        ivPokemon = findViewById<View?>(R.id.iv_detail_pokemon) as ImageView
        requestData(pokemon)
    }

    private fun requestData(pokemon: Pokemon?) {
        if (pokemon != null) {
            tvName?.setText(pokemon.getName())
            tvTypes?.setText(pokemon.pokemonTypesToString())
            tvAttack?.setText("Attack: " + pokemon.getAttack().toString())
            tvDefense?.setText("Defense: " + pokemon.getDefense().toString())
            tvSpeed?.setText("Speed: " + pokemon.getSpeed().toString())
            Picasso.get()
                    .load(pokemon.getSprites()?.frontDefault)
                    .resize(64, 64)
                    .into(ivPokemon)
        }

    }
}