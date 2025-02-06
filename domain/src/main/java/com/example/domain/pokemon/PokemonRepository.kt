package com.example.domain.pokemon

import com.example.domain.pokemon.model.Pokemon

interface PokemonRepository {
    suspend fun getPokemons(page: Int, pageSize: Int): List<Pokemon>
    suspend fun searchPokemon(query: String): Pokemon?

}