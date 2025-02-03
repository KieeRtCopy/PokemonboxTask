package com.example.data.pokemon

import com.example.data.pokemon.data_source.PokemonDataSourceRemote
import com.example.domain.pokemon.PokemonRepository
import com.example.domain.pokemon.model.Pokemon

class PokemonRepositoryImpl(private val pokemonDataSourceRemote: PokemonDataSourceRemote) : PokemonRepository {
    override suspend fun getPokemons(page: Int, pageSize: Int): List<Pokemon> {
        TODO("Not yet implemented")
    }

    override suspend fun searchPokemons(query: String, page: Int, pageSize: Int): List<Pokemon> {
        TODO("Not yet implemented")
    }

}