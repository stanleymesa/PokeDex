package com.stanleymesa.pokedex.data.remote

import com.stanleymesa.pokedex.data.model.PokemonDTO
import com.stanleymesa.pokedex.data.model.PokemonListDTO
import com.stanleymesa.pokedex.utils.network.BaseListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonRemoteService {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): BaseListResponse<PokemonListDTO>

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String
    ): PokemonDTO

}