package com.example.data.pokemon.data_source_impl.remote.api

import retrofit2.Call
import retrofit2.http.GET
import java.util.Objects

interface PokemonService {

    @GET("pokemon")
    suspend fun getPokemonList(): Call<Objects>

}