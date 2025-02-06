package com.example.pokemonlist.adapter


import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.pokemon.model.Pokemon
import com.example.pokemonlist.R
import com.example.pokemonlist.ui.PokemonItemView

/**
 * Adapter per visualizzare una lista di Pokémon utilizzando la custom view [PokemonItemView].
 *
 * @param items La lista dei Pokémon da visualizzare.
 * @param itemClickListener (opzionale) Callback invocata al click sull'item.
 */
class PokemonAdapter(
    private var items: List<Pokemon>,
    private val itemClickListener: ((Pokemon) -> Unit)? = null
) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        // Istanzia la custom view utilizzando il contesto del parent.
        val itemView = PokemonItemView(parent.context, isForRecyclerView = true)
        return PokemonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = items[position]
        holder.bind(pokemon)
        // Imposta il listener per il click sull'intero item.
        holder.itemView.setOnClickListener {
            itemClickListener?.invoke(pokemon)
        }
    }

    override fun getItemCount(): Int = items.size

    /**
     * Aggiorna la lista degli elementi e notifica l'adapter.
     */
    fun setItems(newItems: List<Pokemon>) {
        items = newItems
        notifyDataSetChanged()
    }

    /**
     * ViewHolder che utilizza [PokemonItemView] per mostrare i dati.
     */
    class PokemonViewHolder(private val pokemonItemView: PokemonItemView) :
        RecyclerView.ViewHolder(pokemonItemView) {

        fun bind(pokemon: Pokemon) {
            // Imposta il titolo e la descrizione
            pokemonItemView.setTitle(pokemon.name)
            pokemonItemView.setDescription(pokemon.description ?: "")

            // Imposta l'icona se disponibile.
            // Se il modello non contiene una risorsa drawable (ma un URL) potresti usare una libreria
            // come Glide o Coil. Per ora usiamo un placeholder.
            pokemonItemView.loadImage(pokemon.imageUrl);

            // Pulisce il ChipGroup e aggiunge una Chip per ogni tipo.
            pokemonItemView.clearTypes()
            pokemon.types.forEach { type ->
                pokemonItemView.addTypeChip(type)
            }
        }
    }
}