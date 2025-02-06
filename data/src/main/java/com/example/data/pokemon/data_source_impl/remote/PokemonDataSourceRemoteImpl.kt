package com.example.data.pokemon.data_source_impl.remote

import com.example.data.pokemon.data_source.PokemonDataSourceRemote
import com.example.data.pokemon.data_source_impl.remote.api.PokemonService
import com.example.data.pokemon.data_source_impl.remote.dto.PokemonDto
import com.example.data.pokemon.data_source_impl.remote.dto.PokemonSpeciesDto
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

class PokemonDataSourceRemoteImpl(
    private val apiService: PokemonService
) : PokemonDataSourceRemote {

    override suspend fun fetchPokemons(page: Int, pageSize: Int): List<PokemonDto> = coroutineScope {
        val offset = (page - 1) * pageSize
        val paginatedResponse = apiService.getPokemons(limit = pageSize, offset = offset)
        val enrichedDeferred = paginatedResponse.results.map { result ->
            async {
                val detailDeferred = async { apiService.searchPokemon(name = result.name) }
                val descriptionDeferred = async { fetchDescription(result.name) }
                val detail = detailDeferred.await()
                val description = descriptionDeferred.await()
                detail.copy(description = description)
            }
        }
        val result : List<PokemonDto> = enrichedDeferred.awaitAll()
        return@coroutineScope result;
    }

    override suspend fun searchPokemon(query: String): PokemonDto  = coroutineScope {
        val detailDeferred = async { apiService.searchPokemon(name = query) }
        val descriptionDeferred = async { fetchDescription(query) }
        val detail = detailDeferred.await()
        val description = descriptionDeferred.await()
        detail.copy(description = description)
        return@coroutineScope detail;
    }


    private suspend fun fetchDescription(pokemonName: String): String? {
        return try {
            val speciesResponse = apiService.getPokemonSpecies(pokemonName)
            speciesResponse.flavorTextEntries
                .firstOrNull { entry ->
                    entry.language.name == "en" && entry.version.name == "shield"
                }
                ?.flavorText
                ?.replace("\n", " ")
                ?.replace("""\f""", " ")
        } catch (e: Exception) {
            null
        }
    }
}