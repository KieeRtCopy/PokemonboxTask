package com.example.pokemonlist.presentation

import com.example.domain.pokemon.PokemonRepository
import com.example.domain.pokemon.model.Pokemon

class FakePokemonRepository : PokemonRepository {
    var pokemons: List<Pokemon> = emptyList()
    var searchResult: Pokemon? = null

    override suspend fun getPokemons(page: Int, pageSize: Int): List<Pokemon> {
        return pokemons
    }

    override suspend fun searchPokemon(query: String): Pokemon? {
        return searchResult
    }
}