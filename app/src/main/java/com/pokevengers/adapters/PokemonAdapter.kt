package com.pokevengers.adapters


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.pokevengers.R
import com.pokevengers.adapters.PokemonAdapter.PokeViewHolder
import com.pokevengers.entities.Pokemon
import com.squareup.picasso.Picasso

class PokemonAdapter(private val pokemonList: MutableList<Pokemon?>?) : RecyclerView.Adapter<PokeViewHolder?>() {

    inner class PokeViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var name: TextView?
        var type: TextView?
        var ivPokemon: ImageView?

        init {
            name = itemView?.findViewById<View?>(R.id.tv_name) as TextView
            type = itemView?.findViewById<View?>(R.id.tv_type) as TextView
            ivPokemon = itemView?.findViewById<View?>(R.id.iv_pokemon) as ImageView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeViewHolder {
        val inflater = LayoutInflater.from(parent.getContext())
        val itemView = inflater.inflate(R.layout.pokemon_row, parent, false)
        return PokeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PokeViewHolder, position: Int) {
        val pokemon = pokemonList?.get(position)
        holder.name?.setText(pokemon?.getName())
        holder.type?.setText(pokemon?.pokemonTypesToString())
        Picasso.get()
                .load(pokemon?.getSprites()?.frontDefault)
                .resize(64, 64)
                .into(holder.ivPokemon)
    }

    override fun getItemCount(): Int {
        return pokemonList?.size!!
    }

}