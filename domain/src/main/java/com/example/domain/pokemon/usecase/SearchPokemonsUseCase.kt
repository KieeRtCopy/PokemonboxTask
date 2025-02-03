package com.example.domain.pokemon.usecase

import com.example.domain.pokemon.PokemonRepository
import com.example.domain.pokemon.model.Pokemon

class SearchPokemonsUseCase(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(query: String, page: Int, pageSize: Int): List<Pokemon> {
        return repository.searchPokemons(query, page, pageSize)
    }
}