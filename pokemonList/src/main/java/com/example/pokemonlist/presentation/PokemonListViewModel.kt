package com.example.pokemonlist.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.pokemon.usecase.GetPokemonsUseCase
import com.example.domain.pokemon.usecase.SearchPokemonUseCase
import com.example.pokemonlist.presentation.mvi.PokemonListIntent
import com.example.pokemonlist.presentation.mvi.PokemonListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase,
    private val searchPokemonUseCase: SearchPokemonUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(PokemonListState())
    val state: StateFlow<PokemonListState> = _state

    private var currentPage = 1
    private val pageSize = 20
    private var currentQuery: String? = null

    fun processIntent(intent: PokemonListIntent) {
        when (intent) {
            is PokemonListIntent.InitialLoad -> loadPokemons(reset = true)
            is PokemonListIntent.LoadNextPage -> loadPokemons(reset = false)
            is PokemonListIntent.Search -> {
                currentQuery = if (intent.query.isNotEmpty()) intent.query else null
                if (currentQuery != null) {
                    searchPokemon(currentQuery!!)
                } else {
                    // Se il campo di ricerca è stato svuotato, si ripristina la lista precedente
                    loadPokemons(reset = true)
                }
            }
        }
    }

    private fun loadPokemons(reset: Boolean) {
        viewModelScope.launch {
            if (reset) {
                currentPage = 1
                _state.value = _state.value.copy(isLoading = true, error = null)
            } else {
                _state.value = _state.value.copy(isLoading = true, error = null)
            }
            try {
                val newItems = getPokemonsUseCase(currentPage, pageSize)
                val currentList = if (reset) emptyList() else _state.value.pokemons
                val updatedList = currentList + newItems
                _state.value = _state.value.copy(
                    pokemons = updatedList,
                    isLoading = false,
                    hasMore = newItems.size == pageSize
                )
                if (newItems.isNotEmpty()) currentPage++
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = e.localizedMessage ?: "Errore generico"
                )
            }
        }
    }

    private fun searchPokemon(query: String) {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)
            try {
                val result = searchPokemonUseCase(query)
                val updatedList = result?.let { listOf(it) } ?: emptyList()
                _state.value = _state.value.copy(
                    pokemons = updatedList,
                    isLoading = false,
                    hasMore = false
                )
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = e.localizedMessage ?: "Errore nella ricerca"
                )
            }
        }
    }
}