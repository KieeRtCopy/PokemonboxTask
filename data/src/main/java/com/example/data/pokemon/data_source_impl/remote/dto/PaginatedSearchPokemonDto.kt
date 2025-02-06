package com.example.data.pokemon.data_source_impl.remote.dto


import com.google.gson.annotations.SerializedName

data class PaginatedSearchPokemonDto(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: String,
    @SerializedName("results")
    val results: List<PokemonResult>
) {
    data class PokemonResult(
        @SerializedName("name")
        val name: String,
        @SerializedName("url")
        val url: String
    )
}