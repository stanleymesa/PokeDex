package com.stanleymesa.pokedex.data.remote

import javax.inject.Inject

class PokemonRemoteDataSource @Inject constructor(
    private val pokemonRemoteService: PokemonRemoteService
) {
    suspend fun getPokemonList(limit: Int, offset: Int) =
        pokemonRemoteService.getPokemonList(limit, offset)

    suspend fun getPokemonInfo(name: String) = pokemonRemoteService.getPokemonInfo(name)

}