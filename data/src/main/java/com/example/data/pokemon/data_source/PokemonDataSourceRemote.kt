package com.example.data.pokemon.data_source

import com.example.data.pokemon.data_source_impl.remote.dto.PokemonDto

interface PokemonDataSourceRemote {
    /**
     * Recupera la lista paginata di Pokémon.
     * Per ciascun elemento (con nome e url) si effettua una chiamata
     * per ottenere i dettagli tramite il metodo searchPokemon.
     */
    suspend fun fetchPokemons(page: Int, pageSize: Int): List<PokemonDto>

    /**
     * Recupera i dettagli di un singolo Pokémon in base al nome.
     */
    suspend fun searchPokemon(query: String): PokemonDto

}