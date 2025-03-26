package com.example.feature.home.domain

import com.example.feature.home.domain.model.Pokemon

interface PokemonRepository {
    suspend fun getPokemons(page: Int, pageSize: Int): List<Pokemon>
    suspend fun searchPokemon(query: String): Pokemon?

}