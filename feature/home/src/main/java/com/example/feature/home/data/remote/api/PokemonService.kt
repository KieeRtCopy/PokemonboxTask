package com.example.feature.home.data.remote.api

import com.example.feature.home.data.remote.dto.PaginatedSearchPokemonDto
import com.example.feature.home.data.remote.dto.PokemonDto
import com.example.feature.home.data.remote.dto.PokemonSpeciesDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon")
    suspend fun getPokemons(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PaginatedSearchPokemonDto

    @GET("pokemon/{name}")
    suspend fun searchPokemon(
        @Path("name") name: String
    ): PokemonDto

    @GET("pokemon-species/{name}")
    suspend fun getPokemonSpecies(
        @Path("name") name: String
    ): PokemonSpeciesDto

}