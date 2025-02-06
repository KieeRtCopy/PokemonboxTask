package com.example.pokemonlist.presentation.mvi


sealed class PokemonListIntent {
    object InitialLoad : PokemonListIntent()
    object LoadNextPage : PokemonListIntent()
    data class Search(val query: String) : PokemonListIntent()
}
