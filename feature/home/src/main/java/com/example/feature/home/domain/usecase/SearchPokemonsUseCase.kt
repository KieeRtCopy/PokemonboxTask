package com.example.feature.home.domain.usecase

import com.example.feature.home.domain.PokemonRepository
import com.example.feature.home.domain.model.Pokemon
import javax.inject.Inject

class SearchPokemonUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(query: String): Pokemon? {
        return repository.searchPokemon(query)
    }
}