package com.stanleymesa.pokedex.domain.repository

import com.stanleymesa.pokedex.domain.model.Pokemon
import com.stanleymesa.pokedex.utils.network.Resource
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    suspend fun getPokemonInfo(name: String): Flow<Resource<Pokemon>>
}