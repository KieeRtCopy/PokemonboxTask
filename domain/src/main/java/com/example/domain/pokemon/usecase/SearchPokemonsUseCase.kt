package com.example.domain.pokemon.usecase

import com.example.domain.pokemon.PokemonRepository
import com.example.domain.pokemon.model.Pokemon
import javax.inject.Inject

class SearchPokemonUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(query: String): Pokemon? {
        return repository.searchPokemon(query)
    }
}