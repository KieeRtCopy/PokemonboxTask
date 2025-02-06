package com.example.pokemonlist.presentation.mvi

import com.example.domain.pokemon.model.Pokemon

data class PokemonListState(
    val isLoading: Boolean = false,
    val pokemons: List<Pokemon> = emptyList(),
    val error: String? = null,
    val hasMore: Boolean = true
)