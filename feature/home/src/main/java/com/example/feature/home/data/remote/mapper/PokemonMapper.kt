package com.example.feature.home.data.remote.mapper

import com.example.feature.home.data.remote.dto.PokemonDto
import com.example.feature.home.domain.model.Pokemon


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