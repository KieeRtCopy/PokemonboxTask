package com.example.pokemonlist.presentation

import com.example.domain.pokemon.model.Pokemon
import com.example.domain.pokemon.usecase.GetPokemonsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetPokemonsUseCaseTest {

    private lateinit var fakeRepository: FakePokemonRepository
    private lateinit var getPokemonsUseCase: GetPokemonsUseCase

    @Before
    fun setup() {
        fakeRepository = FakePokemonRepository()
        getPokemonsUseCase = GetPokemonsUseCase(fakeRepository)
    }

    @Test
    fun `invoke returns list of pokemons when repository returns data`() = runTest {
        val pokemon1 = Pokemon(
            id = 1,
            name = "Bulbasaur",
            types = listOf("grass", "poison"),
            description = "A test description",
            imageUrl = "url1"
        )
        val pokemon2 = Pokemon(
            id = 2,
            name = "Ivysaur",
            types = listOf("grass", "poison"),
            description = "Another test description",
            imageUrl = "url2"
        )
        fakeRepository.pokemons = listOf(pokemon1, pokemon2)

        val result = getPokemonsUseCase(page = 1, pageSize = 20)
        assertEquals(2, result.size)
        assertEquals("Bulbasaur", result[0].name)
        assertEquals("Ivysaur", result[1].name)
    }

    @Test
    fun `invoke returns empty list when repository returns no data`() = runTest {
        fakeRepository.pokemons = emptyList()

        val result = getPokemonsUseCase(page = 1, pageSize = 20)
        assertEquals(0, result.size)
    }
}