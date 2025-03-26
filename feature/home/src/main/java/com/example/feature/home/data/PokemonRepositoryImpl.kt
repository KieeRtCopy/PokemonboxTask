package com.example.feature.home.data

import com.example.feature.home.data.data_source.PokemonDataSourceRemote
import com.example.feature.home.data.remote.mapper.toDomain
import com.example.feature.home.domain.PokemonRepository
import com.example.feature.home.domain.model.Pokemon

class PokemonRepositoryImpl(private val pokemonDataSourceRemote: PokemonDataSourceRemote) :
    PokemonRepository {
    override suspend fun getPokemons(page: Int, pageSize: Int): List<Pokemon> {
        return pokemonDataSourceRemote.fetchPokemons(page, pageSize)
            .map { it.toDomain() }
    }

    override suspend fun searchPokemon(query: String): Pokemon? {
        return try {
            val dto = pokemonDataSourceRemote.searchPokemon(query)
            dto.toDomain()
        } catch (e: Exception) {
            null
        }
    }
}