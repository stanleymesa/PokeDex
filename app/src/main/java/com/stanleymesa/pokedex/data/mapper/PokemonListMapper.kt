package com.stanleymesa.pokedex.data.mapper

import com.stanleymesa.pokedex.data.model.PokemonListDTO
import com.stanleymesa.pokedex.domain.model.PokemonList

object PokemonListMapper {

    fun PokemonListDTO?.toDomainModel() = PokemonList(
        name = this?.name?.replaceFirstChar { it.uppercase() }.orEmpty(),
        imageUrl = kotlin.runCatching {
            val url = this?.url
            var number = 1
            if (!url.isNullOrEmpty()) {
                number = if (url.endsWith("/")) {
                    url.dropLast(1).takeLastWhile { it.isDigit() }.toInt()
                } else {
                    url.takeLastWhile { it.isDigit() }.toInt()
                }
            }
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$number.png"
        }
            .getOrElse { "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png" },
        number = kotlin.runCatching {
            val url = this?.url
            var number = 1
            if (!url.isNullOrEmpty()) {
                number = if (url.endsWith("/")) {
                    url.dropLast(1).takeLastWhile { it.isDigit() }.toInt()
                } else {
                    url.takeLastWhile { it.isDigit() }.toInt()
                }
            }
            number
        }.getOrElse { 1 }
    )

}