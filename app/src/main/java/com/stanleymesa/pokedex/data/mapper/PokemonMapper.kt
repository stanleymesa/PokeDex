package com.stanleymesa.pokedex.data.mapper

import com.stanleymesa.pokedex.data.model.Crystal
import com.stanleymesa.pokedex.data.model.DreamWorld
import com.stanleymesa.pokedex.data.model.GenerationI
import com.stanleymesa.pokedex.data.model.GenerationIi
import com.stanleymesa.pokedex.data.model.GenerationIii
import com.stanleymesa.pokedex.data.model.Gold
import com.stanleymesa.pokedex.data.model.Home
import com.stanleymesa.pokedex.data.model.OfficialArtwork
import com.stanleymesa.pokedex.data.model.Other
import com.stanleymesa.pokedex.data.model.PokemonDTO
import com.stanleymesa.pokedex.data.model.PokemonListDTO
import com.stanleymesa.pokedex.data.model.RedBlue
import com.stanleymesa.pokedex.data.model.ResultsItem
import com.stanleymesa.pokedex.data.model.Silver
import com.stanleymesa.pokedex.data.model.Sprites
import com.stanleymesa.pokedex.data.model.Type
import com.stanleymesa.pokedex.data.model.TypesItem
import com.stanleymesa.pokedex.data.model.Versions
import com.stanleymesa.pokedex.data.model.Yellow
import com.stanleymesa.pokedex.domain.model.Pokemon
import com.stanleymesa.pokedex.domain.model.PokemonList
import com.stanleymesa.pokedex.domain.model.PokemonListResults
import com.stanleymesa.pokedex.utils.orFalse
import com.stanleymesa.pokedex.utils.orZero

object PokemonMapper {

    fun PokemonDTO?.toDomainModel() = Pokemon(
        locationAreaEncounters = this?.locationAreaEncounters.orEmpty(),
        types = this?.types?.filterNotNull()?.map { it.toDomainModel() }.orEmpty(),
        baseExperience = this?.baseExperience.orZero(),
        heldItems = this?.heldItems?.filterNotNull().orEmpty(),
        weight = this?.weight.orZero(),
        isDefault = this?.isDefault.orFalse(),
        pastTypes = this?.pastTypes?.filterNotNull().orEmpty(),
        sprites
    )

    fun TypesItem?.toDomainModel() = com.stanleymesa.pokedex.domain.model.TypesItem(
        slot = this?.slot.orZero(),
        type = this?.type.toDomainModel()
    )

    fun Type?.toDomainModel() = com.stanleymesa.pokedex.domain.model.Type(
        name = this?.name.orEmpty(),
        url = this?.name.orEmpty()
    )

    fun Sprites?.toDomainModel() = com.stanleymesa.pokedex.domain.model.Sprites(
        backShinyFemale = this?.backShinyFemale.orEmpty(),
        backFemale = this?.backFemale.orEmpty(),
        other = this?.other.toDomainModel(),
        backDefault = this?.backDefault.orEmpty(),
        frontShinyFemale = this?.frontShinyFemale.orEmpty(),
        frontDefault = this?.frontDefault.orEmpty(),
        versions
    )

    fun Other?.toDomainModel() = com.stanleymesa.pokedex.domain.model.Other(
        dreamWorld = this?.dreamWorld.toDomainModel(),
        officialArtwork = this?.officialArtwork.toDomainModel(),
        home = this?.home.toDomainModel()
    )

    fun DreamWorld?.toDomainModel() = com.stanleymesa.pokedex.domain.model.DreamWorld(
        frontDefault = this?.frontDefault.orEmpty(),
        frontFemale = this?.frontFemale.orEmpty()
    )

    fun OfficialArtwork?.toDomainModel() = com.stanleymesa.pokedex.domain.model.OfficialArtwork(
        frontDefault = this?.frontDefault.orEmpty(),
        frontShiny = this?.frontShiny.orEmpty()
    )

    fun Home?.toDomainModel() = com.stanleymesa.pokedex.domain.model.Home(
        frontShinyFemale = this?.frontShinyFemale.orEmpty(),
        frontDefault = this?.frontDefault.orEmpty(),
        frontFemale = this?.frontFemale.orEmpty(),
        frontShiny = this?.frontShiny.orEmpty()
    )

    fun Versions?.toDomainModel() = com.stanleymesa.pokedex.domain.model.Versions(
        generationI = this?.generationI.toDomainModel(),
        generationIi = this?.generationIi.toDomainModel(),
        generationIii =
    )

    fun GenerationI?.toDomainModel() = com.stanleymesa.pokedex.domain.model.GenerationI(
        yellow = this?.yellow.toDomainModel(),
        redBlue = this?.redBlue.toDomainModel()
    )

    fun Yellow?.toDomainModel() = com.stanleymesa.pokedex.domain.model.Yellow(
        frontGray = this?.frontGray.orEmpty(),
        backTransparent = this?.backTransparent.orEmpty(),
        backDefault = this?.backDefault.orEmpty(),
        backGray = this?.backGray.orEmpty(),
        frontDefault = this?.frontDefault.orEmpty(),
        frontTransparent = this?.frontTransparent.orEmpty()
    )

    fun RedBlue?.toDomainModel() = com.stanleymesa.pokedex.domain.model.RedBlue(
        frontGray = this?.frontGray.orEmpty(),
        backTransparent = this?.backTransparent.orEmpty(),
        backDefault = this?.backDefault.orEmpty(),
        backGray = this?.backGray.orEmpty(),
        frontDefault = this?.frontDefault.orEmpty(),
        frontTransparent = this?.frontTransparent.orEmpty()
    )

    fun GenerationIi?.toDomainModel() = com.stanleymesa.pokedex.domain.model.GenerationIi(
        gold = this?.gold.toDomainModel(),
        crystal = this?.crystal.toDomainModel(),
        silver = this?.silver.toDomainModel()
    )

    fun Gold?.toDomainModel() = com.stanleymesa.pokedex.domain.model.Gold(
        frontShiny = this?.frontShiny.orEmpty(),
        backDefault = this?.backDefault.orEmpty(),
        frontDefault = this?.frontDefault.orEmpty(),
        frontTransparent = this?.frontTransparent.orEmpty(),
        backShiny = this?.backShiny.orEmpty()
    )

    fun Crystal?.toDomainModel() = com.stanleymesa.pokedex.domain.model.Crystal(
        frontShiny = this?.frontShiny.orEmpty(),
        backDefault = this?.backDefault.orEmpty(),
        frontDefault = this?.frontDefault.orEmpty(),
        backTransparent = this?.backTransparent.orEmpty(),
        backShinyTransparent = this?.backShinyTransparent.orEmpty(),
        frontTransparent = this?.frontTransparent.orEmpty(),
        frontShinyTransparent = this?.frontShinyTransparent.orEmpty(),
        backShiny = this?.backShiny.orEmpty()
    )

    fun Silver?.toDomainModel() = com.stanleymesa.pokedex.domain.model.Silver(
        frontShiny = this?.frontShiny.orEmpty(),
        backDefault = this?.backDefault.orEmpty(),
        frontDefault = this?.frontDefault.orEmpty(),
        frontTransparent = this?.frontTransparent.orEmpty(),
        backShiny = this?.backShiny.orEmpty(),
    )

    fun GenerationIii?.toDomainModel() = com.stanleymesa.pokedex.domain.model.GenerationIii(
        fireredLeafgreen =
    )



}