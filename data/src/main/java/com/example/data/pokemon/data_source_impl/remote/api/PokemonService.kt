package com.example.data.pokemon.data_source_impl.remote.api

import com.example.data.pokemon.data_source_impl.remote.dto.PaginatedSearchPokemonDto
import com.example.data.pokemon.data_source_impl.remote.dto.PokemonDto
import com.example.data.pokemon.data_source_impl.remote.dto.PokemonSpeciesDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.Objects

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