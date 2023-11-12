package com.stanleymesa.pokedex.data.remote

import javax.inject.Inject

class PokemonRemoteDataSource @Inject constructor(
    private val pokemonRemoteService: PokemonRemoteService
) {

    suspend fun getPokemoninfo(name: String) = pokemonRemoteService.getPokemonInfo(name)

}