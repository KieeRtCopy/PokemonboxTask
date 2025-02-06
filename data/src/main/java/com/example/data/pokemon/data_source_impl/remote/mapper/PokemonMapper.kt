package com.example.data.pokemon.data_source_impl.remote.mapper

import com.example.data.pokemon.data_source_impl.remote.dto.PokemonDto
import com.example.domain.pokemon.model.Pokemon


fun PokemonDto.toDomain(): Pokemon {
    return Pokemon(
        id = this.id,
        name = this.name.capitalizeFirstChar(),
        types = this.types.map { it.type.name },
        description = description,
        imageUrl = this.sprites.other.officialArtwork.frontDefault
    )
}

fun String.capitalizeFirstChar(): String {
    if (this.isEmpty()) return this
    return this[0].uppercaseChar() + this.substring(1)
}