package com.stanleymesa.pokedex.data.mapper

import com.stanleymesa.pokedex.data.model.PokemonListDTO
import com.stanleymesa.pokedex.data.model.ResultsItem
import com.stanleymesa.pokedex.domain.model.PokemonList
import com.stanleymesa.pokedex.domain.model.PokemonListResults
import com.stanleymesa.pokedex.utils.orZero

object PokemonListMapper {

    fun PokemonListDTO?.toDomainModel() = PokemonList(
        next = this?.next.orEmpty(),
        previous = this?.previous.orEmpty(),
        count = this?.count.orZero(),
        results = this?.results?.filterNotNull()?.map { it.toDomainModel() }.orEmpty()
    )

    private fun ResultsItem?.toDomainModel() = PokemonListResults(
        name = this?.name.orEmpty(),
        url = this?.url.orEmpty()
    )

}