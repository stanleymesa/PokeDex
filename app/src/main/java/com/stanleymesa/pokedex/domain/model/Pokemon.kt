package com.stanleymesa.pokedex.domain.model


data class Pokemon(

    val locationAreaEncounters: String,

    val types: List<TypesItem>,

    val baseExperience: Int,

    val heldItems: List<String>,

    val weight: Int,

    val isDefault: Boolean,

    val pastTypes: List<String>,

    val sprites: Sprites,

    val pastAbilities: List<String>,

    val abilities: List<AbilitiesItem>,

    val gameIndices: List<GameIndicesItem>,

    val species: Species,

    val stats: List<StatsItem>,

    val moves: List<MovesItem>,

    val name: String,

    val id: Int,

    val forms: List<FormsItem>,

    val height: Int,

    val order: Int
)

data class TypesItem(

    val slot: Int,

    val type: Type
)

data class GenerationV(

    val blackWhite: BlackWhite
)

data class GenerationVii(

    val icons: Icons,

    val ultraSunUltraMoon: UltraSunUltraMoon
)

data class RubySapphire(

    val backDefault: String,

    val frontDefault: String,

    val backShiny: String,

    val frontShiny: String
)

data class Animated(

    val backShinyFemale: String,

    val backFemale: String,

    val backDefault: String,

    val frontShinyFemale: String,

    val frontDefault: String,

    val frontFemale: String,

    val backShiny: String,

    val frontShiny: String
)

data class GenerationI(

    val yellow: Yellow,

    val redBlue: RedBlue
)

data class Type(

    val name: String,

    val url: String
)

data class OfficialArtwork(

    val frontDefault: String,

    val frontShiny: String
)

data class MoveLearnMethod(

    val name: String,

    val url: String
)

data class GenerationIii(

    val fireredLeafgreen: FireredLeafgreen,

    val rubySapphire: RubySapphire,

    val emerald: Emerald
)

data class Home(

    val frontShinyFemale: String,

    val frontDefault: String,

    val frontFemale: String,

    val frontShiny: String
)

data class GenerationIv(

    val platinum: Platinum,

    val diamondPearl: DiamondPearl,

    val heartgoldSoulsilver: HeartgoldSoulsilver
)

data class Sprites(

    val backShinyFemale: String,

    val backFemale: String,

    val other: Other,

    val backDefault: String,

    val frontShinyFemale: String,

    val frontDefault: String,

    val versions: Versions,

    val frontFemale: String,

    val backShiny: String,

    val frontShiny: String
)

data class Platinum(

    val backShinyFemale: String,

    val backFemale: String,

    val backDefault: String,

    val frontShinyFemale: String,

    val frontDefault: String,

    val frontFemale: String,

    val backShiny: String,

    val frontShiny: String
)

data class FormsItem(

    val name: String,

    val url: String
)

data class Crystal(

    val backTransparent: String,

    val backShinyTransparent: String,

    val backDefault: String,

    val frontDefault: String,

    val frontTransparent: String,

    val frontShinyTransparent: String,

    val backShiny: String,

    val frontShiny: String
)

data class Icons(

    val frontDefault: String,

    val frontFemale: String
)

data class GenerationViii(

    val icons: Icons
)

data class RedBlue(

    val frontGray: String,

    val backTransparent: String,

    val backDefault: String,

    val backGray: String,

    val frontDefault: String,

    val frontTransparent: String
)

data class GenerationIi(

    val gold: Gold,

    val crystal: Crystal,

    val silver: Silver
)

data class Stat(

    val name: String,

    val url: String
)

data class Other(

    val dreamWorld: DreamWorld,

    val officialArtwork: OfficialArtwork,

    val home: Home
)

data class UltraSunUltraMoon(

    val frontShinyFemale: String,

    val frontDefault: String,

    val frontFemale: String,

    val frontShiny: String
)

data class OmegarubyAlphasapphire(

    val frontShinyFemale: String,

    val frontDefault: String,

    val frontFemale: String,

    val frontShiny: String
)

data class Emerald(

    val frontDefault: String,

    val frontShiny: String
)

data class AbilitiesItem(

    val isHidden: Boolean,

    val ability: Ability,

    val slot: Int
)

data class VersionGroup(

    val name: String,

    val url: String
)

data class FireredLeafgreen(

    val backDefault: String,

    val frontDefault: String,

    val backShiny: String,

    val frontShiny: String
)

data class DreamWorld(

    val frontDefault: String,

    val frontFemale: String
)

data class Version(

    val name: String,

    val url: String
)

data class StatsItem(

    val stat: Stat,

    val baseStat: Int,

    val effort: Int
)

data class Species(

    val name: String,

    val url: String
)

data class Silver(

    val backDefault: String,

    val frontDefault: String,

    val frontTransparent: String,

    val backShiny: String,

    val frontShiny: String
)

data class BlackWhite(

    val backShinyFemale: String,

    val backFemale: String,

    val backDefault: String,

    val frontShinyFemale: String,

    val frontDefault: String,

    val animated: Animated,

    val frontFemale: String,

    val backShiny: String,

    val frontShiny: String
)

data class HeartgoldSoulsilver(

    val backShinyFemale: String,

    val backFemale: String,

    val backDefault: String,

    val frontShinyFemale: String,

    val frontDefault: String,

    val frontFemale: String,

    val backShiny: String,

    val frontShiny: String
)

data class Move(

    val name: String,

    val url: String
)

data class VersionGroupDetailsItem(

    val levelLearnedAt: Int,

    val versionGroup: VersionGroup,

    val moveLearnMethod: MoveLearnMethod
)

data class Gold(

    val backDefault: String,

    val frontDefault: String,

    val frontTransparent: String,

    val backShiny: String,

    val frontShiny: String
)

data class Ability(

    val name: String,

    val url: String
)

data class XY(

    val frontShinyFemale: String,

    val frontDefault: String,

    val frontFemale: String,

    val frontShiny: String
)

data class GameIndicesItem(

    val gameIndex: Int,

    val version: Version
)

data class MovesItem(

    val versionGroupDetails: List<VersionGroupDetailsItem>,

    val move: Move
)

data class DiamondPearl(

    val backShinyFemale: String,

    val backFemale: String,

    val backDefault: String,

    val frontShinyFemale: String,

    val frontDefault: String,

    val frontFemale: String,

    val backShiny: String,

    val frontShiny: String
)

data class Versions(

    val generationIii: GenerationIii,

    val generationIi: GenerationIi,

    val generationV: GenerationV,

    val generationIv: GenerationIv,

    val generationVii: GenerationVii,

    val generationI: GenerationI,

    val generationViii: GenerationViii,

    val generationVi: GenerationVi
)

data class Yellow(

    val frontGray: String,

    val backTransparent: String,

    val backDefault: String,

    val backGray: String,

    val frontDefault: String,

    val frontTransparent: String
)

data class GenerationVi(

    val omegarubyAlphasapphire: OmegarubyAlphasapphire,

    val xY: XY
)

