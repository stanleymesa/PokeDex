package com.stanleymesa.pokedex.domain.model

import java.util.UUID

data class PokemonList(
    val name: String = "",
    val imageUrl: String = "",
    val number: Int = 0,
    val id: String = UUID.randomUUID().toString()
)
