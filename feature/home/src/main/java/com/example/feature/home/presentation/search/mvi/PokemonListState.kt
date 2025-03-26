package com.example.feature.home.presentation.search.mvi

import com.example.feature.home.domain.model.Pokemon


data class PokemonListState(
    val isLoading: Boolean = false,
    val pokemons: List<Pokemon> = emptyList(),
    val error: String? = null,
    val hasMore: Boolean = true
)