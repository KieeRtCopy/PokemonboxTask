package com.example.data.pokemon.data_source_impl.remote.dto

import com.google.gson.annotations.SerializedName

data class PokemonSpeciesDto(
    @SerializedName("flavor_text_entries")
    val flavorTextEntries: List<FlavorTextEntry>
) {
    data class FlavorTextEntry(
        @SerializedName("flavor_text")
        val flavorText: String,
        @SerializedName("language")
        val language: NamedResource,
        @SerializedName("version")
        val version: NamedResource
    )

    data class NamedResource(
        @SerializedName("name")
        val name: String,
        @SerializedName("url")
        val url: String
    )
}