package com.example.feature.home.domain.usecase

import com.example.feature.home.domain.PokemonRepository
import com.example.feature.home.domain.model.Pokemon
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(page: Int, pageSize: Int): List<Pokemon> {
        return repository.getPokemons(page, pageSize)
    }
}