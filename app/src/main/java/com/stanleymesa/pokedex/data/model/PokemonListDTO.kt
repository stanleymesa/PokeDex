package com.stanleymesa.pokedex.data.model

import com.google.gson.annotations.SerializedName

data class PokemonListDTO(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)
