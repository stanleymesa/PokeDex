package com.stanleymesa.pokedex.data.mapper

import com.stanleymesa.pokedex.data.model.AbilitiesItem
import com.stanleymesa.pokedex.data.model.Ability
import com.stanleymesa.pokedex.data.model.Animated
import com.stanleymesa.pokedex.data.model.BlackWhite
import com.stanleymesa.pokedex.data.model.Crystal
import com.stanleymesa.pokedex.data.model.DiamondPearl
import com.stanleymesa.pokedex.data.model.DreamWorld
import com.stanleymesa.pokedex.data.model.Emerald
import com.stanleymesa.pokedex.data.model.FireredLeafgreen
import com.stanleymesa.pokedex.data.model.FormsItem
import com.stanleymesa.pokedex.data.model.GameIndicesItem
import com.stanleymesa.pokedex.data.model.GenerationI
import com.stanleymesa.pokedex.data.model.GenerationIi
import com.stanleymesa.pokedex.data.model.GenerationIii
import com.stanleymesa.pokedex.data.model.GenerationIv
import com.stanleymesa.pokedex.data.model.GenerationV
import com.stanleymesa.pokedex.data.model.GenerationVi
import com.stanleymesa.pokedex.data.model.GenerationVii
import com.stanleymesa.pokedex.data.model.GenerationViii
import com.stanleymesa.pokedex.data.model.Gold
import com.stanleymesa.pokedex.data.model.HeartgoldSoulsilver
import com.stanleymesa.pokedex.data.model.Home
import com.stanleymesa.pokedex.data.model.Icons
import com.stanleymesa.pokedex.data.model.Move
import com.stanleymesa.pokedex.data.model.MoveLearnMethod
import com.stanleymesa.pokedex.data.model.MovesItem
import com.stanleymesa.pokedex.data.model.OfficialArtwork
import com.stanleymesa.pokedex.data.model.OmegarubyAlphasapphire
import com.stanleymesa.pokedex.data.model.Other
import com.stanleymesa.pokedex.data.model.Platinum
import com.stanleymesa.pokedex.data.model.PokemonDTO
import com.stanleymesa.pokedex.data.model.RedBlue
import com.stanleymesa.pokedex.data.model.RubySapphire
import com.stanleymesa.pokedex.data.model.Silver
import com.stanleymesa.pokedex.data.model.Species
import com.stanleymesa.pokedex.data.model.Sprites
import com.stanleymesa.pokedex.data.model.Stat
import com.stanleymesa.pokedex.data.model.StatsItem
import com.stanleymesa.pokedex.data.model.Type
import com.stanleymesa.pokedex.data.model.TypesItem
import com.stanleymesa.pokedex.data.model.UltraSunUltraMoon
import com.stanleymesa.pokedex.data.model.Version
import com.stanleymesa.pokedex.data.model.VersionGroup
import com.stanleymesa.pokedex.data.model.VersionGroupDetailsItem
import com.stanleymesa.pokedex.data.model.Versions
import com.stanleymesa.pokedex.data.model.XY
import com.stanleymesa.pokedex.data.model.Yellow
import com.stanleymesa.pokedex.domain.model.Pokemon
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
        sprites = this?.sprites.toDomainModel(),
        pastAbilities = this?.pastAbilities?.filterNotNull().orEmpty(),
        abilities = this?.abilities?.filterNotNull()?.map { it.toDomainModel() }.orEmpty(),
        gameIndices = this?.gameIndices?.filterNotNull()?.map { it.toDomainModel() }.orEmpty(),
        species = this?.species.toDomainModel(),
        stats = this?.stats?.filterNotNull()?.map { it.toDomainModel() }.orEmpty(),
        moves = this?.moves?.filterNotNull()?.map { it.toDomainModel() }.orEmpty(),
        name = this?.name.orEmpty(),
        id = this?.id.orZero(),
        forms = this?.forms?.filterNotNull()?.map { it.toDomainModel() }.orEmpty(),
        height = this?.height.orZero(),
        order = this?.order.orZero()
    )

    fun FormsItem?.toDomainModel() = com.stanleymesa.pokedex.domain.model.FormsItem(
        name = this?.name.orEmpty(),
        url = this?.url.orEmpty()
    )

    fun MovesItem?.toDomainModel() = com.stanleymesa.pokedex.domain.model.MovesItem(
        versionGroupDetails = this?.versionGroupDetails?.filterNotNull()?.map { it.toDomainModel() }
            .orEmpty(),
        move = this?.move.toDomainModel()
    )

    fun Move?.toDomainModel() = com.stanleymesa.pokedex.domain.model.Move(
        name = this?.name.orEmpty(),
        url = this?.url.orEmpty()
    )

    fun VersionGroupDetailsItem?.toDomainModel() =
        com.stanleymesa.pokedex.domain.model.VersionGroupDetailsItem(
            levelLearnedAt = this?.levelLearnedAt.orZero(),
            versionGroup = this?.versionGroup.toDomainModel(),
            moveLearnMethod = this?.moveLearnMethod.toDomainModel()
        )

    fun MoveLearnMethod?.toDomainModel() = com.stanleymesa.pokedex.domain.model.MoveLearnMethod(
        name = this?.name.orEmpty(),
        url = this?.url.orEmpty()
    )

    fun VersionGroup?.toDomainModel() = com.stanleymesa.pokedex.domain.model.VersionGroup(
        name = this?.name.orEmpty(),
        url = this?.url.orEmpty()
    )

    fun StatsItem?.toDomainModel() = com.stanleymesa.pokedex.domain.model.StatsItem(
        stat = this?.stat.toDomainModel(),
        baseStat = this?.baseStat.orZero(),
        effort = this?.effort.orZero()
    )

    fun Stat?.toDomainModel() = com.stanleymesa.pokedex.domain.model.Stat(
        name = this?.name.orEmpty(),
        url = this?.url.orEmpty()
    )

    fun Species?.toDomainModel() = com.stanleymesa.pokedex.domain.model.Species(
        name = this?.name.orEmpty(),
        url = this?.url.orEmpty()
    )

    fun GameIndicesItem?.toDomainModel() = com.stanleymesa.pokedex.domain.model.GameIndicesItem(
        gameIndex = this?.gameIndex.orZero(),
        version = this?.version.toDomainModel()
    )

    fun Version?.toDomainModel() = com.stanleymesa.pokedex.domain.model.Version(
        name = this?.name.orEmpty(),
        url = this?.url.orEmpty()
    )

    fun AbilitiesItem?.toDomainModel() = com.stanleymesa.pokedex.domain.model.AbilitiesItem(
        isHidden = this?.isHidden.orFalse(),
        ability = this?.ability.toDomainModel(),
        slot = this?.slot.orZero()
    )

    fun Ability?.toDomainModel() = com.stanleymesa.pokedex.domain.model.Ability(
        name = this?.name.orEmpty(),
        url = this?.url.orEmpty()
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
        versions = this?.versions.toDomainModel(),
        frontFemale = this?.frontFemale.orEmpty(),
        backShiny = this?.backShiny.orEmpty(),
        frontShiny = this?.frontShiny.orEmpty()
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
        generationIii = this?.generationIii.toDomainModel(),
        generationIv = this?.generationIv.toDomainModel(),
        generationV = this?.generationV.toDomainModel(),
        generationVi = this?.generationVi.toDomainModel(),
        generationVii = this?.generationVii.toDomainModel(),
        generationViii = this?.generationViii.toDomainModel()
    )

    fun GenerationViii?.toDomainModel() = com.stanleymesa.pokedex.domain.model.GenerationViii(
        icons = this?.icons.toDomainModel()
    )

    fun GenerationVii?.toDomainModel() = com.stanleymesa.pokedex.domain.model.GenerationVii(
        icons = this?.icons.toDomainModel(),
        ultraSunUltraMoon = this?.ultraSunUltraMoon.toDomainModel()
    )

    fun UltraSunUltraMoon?.toDomainModel() = com.stanleymesa.pokedex.domain.model.UltraSunUltraMoon(
        frontShiny = this?.frontShiny.orEmpty(),
        frontDefault = this?.frontDefault.orEmpty(),
        frontShinyFemale = this?.frontShinyFemale.orEmpty(),
        frontFemale = this?.frontFemale.orEmpty()
    )

    fun Icons?.toDomainModel() = com.stanleymesa.pokedex.domain.model.Icons(
        frontDefault = this?.frontDefault.orEmpty(),
        frontFemale = this?.frontFemale.orEmpty()
    )

    fun GenerationVi?.toDomainModel() = com.stanleymesa.pokedex.domain.model.GenerationVi(
        omegarubyAlphasapphire = this?.omegarubyAlphasapphire.toDomainModel(),
        xY = this?.xY.toDomainModel()
    )

    fun XY?.toDomainModel() = com.stanleymesa.pokedex.domain.model.XY(
        frontShiny = this?.frontShiny.orEmpty(),
        frontDefault = this?.frontDefault.orEmpty(),
        frontShinyFemale = this?.frontShinyFemale.orEmpty(),
        frontFemale = this?.frontFemale.orEmpty()
    )

    fun OmegarubyAlphasapphire?.toDomainModel() =
        com.stanleymesa.pokedex.domain.model.OmegarubyAlphasapphire(
            frontShiny = this?.frontShiny.orEmpty(),
            frontDefault = this?.frontDefault.orEmpty(),
            frontShinyFemale = this?.frontShinyFemale.orEmpty(),
            frontFemale = this?.frontFemale.orEmpty()
        )

    fun GenerationV?.toDomainModel() = com.stanleymesa.pokedex.domain.model.GenerationV(
        blackWhite = this?.blackWhite.toDomainModel(),
    )

    fun BlackWhite?.toDomainModel() = com.stanleymesa.pokedex.domain.model.BlackWhite(
        frontShiny = this?.frontShiny.orEmpty(),
        backDefault = this?.backDefault.orEmpty(),
        frontDefault = this?.frontDefault.orEmpty(),
        backShiny = this?.backShiny.orEmpty(),
        backShinyFemale = this?.backShinyFemale.orEmpty(),
        backFemale = this?.backFemale.orEmpty(),
        frontShinyFemale = this?.frontShinyFemale.orEmpty(),
        animated = this?.animated.toDomainModel(),
        frontFemale = this?.frontFemale.orEmpty()
    )

    fun Animated?.toDomainModel() = com.stanleymesa.pokedex.domain.model.Animated(
        frontShiny = this?.frontShiny.orEmpty(),
        backDefault = this?.backDefault.orEmpty(),
        frontDefault = this?.frontDefault.orEmpty(),
        backShiny = this?.backShiny.orEmpty(),
        backShinyFemale = this?.backShinyFemale.orEmpty(),
        backFemale = this?.backFemale.orEmpty(),
        frontShinyFemale = this?.frontShinyFemale.orEmpty(),
        frontFemale = this?.frontFemale.orEmpty()
    )

    fun GenerationIv?.toDomainModel() = com.stanleymesa.pokedex.domain.model.GenerationIv(
        platinum = this?.platinum.toDomainModel(),
        diamondPearl = this?.diamondPearl.toDomainModel(),
        heartgoldSoulsilver = this?.heartgoldSoulsilver.toDomainModel()
    )

    fun Platinum?.toDomainModel() = com.stanleymesa.pokedex.domain.model.Platinum(
        frontShiny = this?.frontShiny.orEmpty(),
        backDefault = this?.backDefault.orEmpty(),
        frontDefault = this?.frontDefault.orEmpty(),
        backShiny = this?.backShiny.orEmpty(),
        backShinyFemale = this?.backShinyFemale.orEmpty(),
        backFemale = this?.backFemale.orEmpty(),
        frontShinyFemale = this?.frontShinyFemale.orEmpty(),
        frontFemale = this?.frontFemale.orEmpty()
    )

    fun DiamondPearl?.toDomainModel() = com.stanleymesa.pokedex.domain.model.DiamondPearl(
        frontShiny = this?.frontShiny.orEmpty(),
        backDefault = this?.backDefault.orEmpty(),
        frontDefault = this?.frontDefault.orEmpty(),
        backShiny = this?.backShiny.orEmpty(),
        backShinyFemale = this?.backShinyFemale.orEmpty(),
        backFemale = this?.backFemale.orEmpty(),
        frontShinyFemale = this?.frontShinyFemale.orEmpty(),
        frontFemale = this?.frontFemale.orEmpty()
    )

    fun HeartgoldSoulsilver?.toDomainModel() =
        com.stanleymesa.pokedex.domain.model.HeartgoldSoulsilver(
            frontShiny = this?.frontShiny.orEmpty(),
            backDefault = this?.backDefault.orEmpty(),
            frontDefault = this?.frontDefault.orEmpty(),
            backShiny = this?.backShiny.orEmpty(),
            backShinyFemale = this?.backShinyFemale.orEmpty(),
            backFemale = this?.backFemale.orEmpty(),
            frontShinyFemale = this?.frontShinyFemale.orEmpty(),
            frontFemale = this?.frontFemale.orEmpty()
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
        fireredLeafgreen = this?.fireredLeafgreen.toDomainModel(),
        rubySapphire = this?.rubySapphire.toDomainModel(),
        emerald = this?.emerald.toDomainModel()
    )

    fun FireredLeafgreen?.toDomainModel() = com.stanleymesa.pokedex.domain.model.FireredLeafgreen(
        frontShiny = this?.frontShiny.orEmpty(),
        backDefault = this?.backDefault.orEmpty(),
        frontDefault = this?.frontDefault.orEmpty(),
        backShiny = this?.backShiny.orEmpty(),
    )

    fun RubySapphire?.toDomainModel() = com.stanleymesa.pokedex.domain.model.RubySapphire(
        frontShiny = this?.frontShiny.orEmpty(),
        backDefault = this?.backDefault.orEmpty(),
        frontDefault = this?.frontDefault.orEmpty(),
        backShiny = this?.backShiny.orEmpty(),
    )

    fun Emerald?.toDomainModel() = com.stanleymesa.pokedex.domain.model.Emerald(
        frontShiny = this?.frontShiny.orEmpty(),
        frontDefault = this?.frontDefault.orEmpty(),
    )

}