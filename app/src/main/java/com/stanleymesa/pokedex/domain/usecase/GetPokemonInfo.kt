package com.stanleymesa.pokedex.domain.usecase

import com.stanleymesa.pokedex.domain.model.Pokemon
import com.stanleymesa.pokedex.domain.repository.PokemonRepository
import com.stanleymesa.pokedex.utils.network.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonInfo @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke(name: String): Flow<Resource<Pokemon>> =
        pokemonRepository.getPokemonInfo(name)
}