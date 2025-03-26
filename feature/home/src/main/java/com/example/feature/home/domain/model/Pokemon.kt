package com.example.feature.home.domain.model

data class Pokemon(
    val id: Int,
    val name: String,
    val types: List<String>,
    val description: String? = null,
    val imageUrl: String? = null
)