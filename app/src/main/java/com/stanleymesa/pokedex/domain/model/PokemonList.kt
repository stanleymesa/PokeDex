package com.stanleymesa.pokedex.domain.model

data class PokemonList(
    val next: String,
    val previous: String,
    val count: Int,
    val results: List<PokemonListResults>
)

data class PokemonListResults(
    val name: String,
    val url: String
)