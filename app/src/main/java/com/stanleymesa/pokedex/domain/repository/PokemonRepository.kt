package com.stanleymesa.pokedex.domain.repository

import androidx.paging.PagingData
import com.stanleymesa.pokedex.domain.model.Pokemon
import com.stanleymesa.pokedex.domain.model.PokemonList
import com.stanleymesa.pokedex.utils.network.Resource
import com.stanleymesa.pokedex.utils.network.ResourcePaging
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    fun getPokemonList(): Flow<PagingData<PokemonList>>

    suspend fun getPokemonInfo(name: String): Flow<Resource<Pokemon>>
}