package com.example.pokemonlist.presentation

import com.example.domain.pokemon.model.Pokemon
import com.example.domain.pokemon.usecase.SearchPokemonUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SearchPokemonUseCaseTest {

    private lateinit var fakeRepository: FakePokemonRepository
    private lateinit var searchPokemonUseCase: SearchPokemonUseCase

    @Before
    fun setup() {
        fakeRepository = FakePokemonRepository()
        searchPokemonUseCase = SearchPokemonUseCase(fakeRepository)
    }

    @Test
    fun `invoke returns a pokemon when repository finds one`() = runTest {
        val expectedPokemon = Pokemon(
            id = 4,
            name = "Pikachu",
            types = listOf("electric"),
            description = "Electric mouse",
            imageUrl = "url4"
        )
        fakeRepository.searchResult = expectedPokemon

        val result = searchPokemonUseCase(query = "Pikachu")
        assertEquals(expectedPokemon, result)
    }

    @Test
    fun `invoke returns null when repository does not find any pokemon`() = runTest {
        fakeRepository.searchResult = null

        val result = searchPokemonUseCase(query = "nonexistent")
        assertNull(result)
    }
}