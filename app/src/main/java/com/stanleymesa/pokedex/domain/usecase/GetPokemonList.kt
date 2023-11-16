package com.stanleymesa.pokedex.domain.usecase

import androidx.paging.PagingData
import com.stanleymesa.pokedex.domain.model.PokemonList
import com.stanleymesa.pokedex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonList @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    operator fun invoke(): Flow<PagingData<PokemonList>> =
        pokemonRepository.getPokemonList()
}