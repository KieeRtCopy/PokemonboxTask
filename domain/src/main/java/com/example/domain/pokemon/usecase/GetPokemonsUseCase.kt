package com.example.domain.pokemon.usecase

import com.example.domain.pokemon.PokemonRepository
import com.example.domain.pokemon.model.Pokemon
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(page: Int, pageSize: Int): List<Pokemon> {
        return repository.getPokemons(page, pageSize)
    }
}