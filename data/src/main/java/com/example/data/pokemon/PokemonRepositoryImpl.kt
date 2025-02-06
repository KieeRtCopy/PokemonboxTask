package com.example.data.pokemon

import com.example.data.pokemon.data_source.PokemonDataSourceRemote
import com.example.data.pokemon.data_source_impl.remote.mapper.toDomain
import com.example.domain.pokemon.PokemonRepository
import com.example.domain.pokemon.model.Pokemon

class PokemonRepositoryImpl(private val pokemonDataSourceRemote: PokemonDataSourceRemote) : PokemonRepository {
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