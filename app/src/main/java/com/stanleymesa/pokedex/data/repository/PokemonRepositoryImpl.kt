package com.stanleymesa.pokedex.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.stanleymesa.pokedex.data.mapper.PokemonMapper.toDomainModel
import com.stanleymesa.pokedex.data.remote.PokemonRemoteDataSource
import com.stanleymesa.pokedex.domain.model.Pokemon
import com.stanleymesa.pokedex.domain.model.PokemonList
import com.stanleymesa.pokedex.domain.repository.PokemonRepository
import com.stanleymesa.pokedex.features.home.paging.PokemonPagingSource
import com.stanleymesa.pokedex.utils.network.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonRemoteDataSource: PokemonRemoteDataSource
) : PokemonRepository {
    override fun getPokemonList(): Flow<PagingData<PokemonList>> =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20,
                prefetchDistance = 1
            ),
            pagingSourceFactory = {
                PokemonPagingSource(pokemonRemoteDataSource)
            }
        ).flow

    override suspend fun getPokemonInfo(name: String): Flow<Resource<Pokemon>> = flow {
        try {
            val response = pokemonRemoteDataSource.getPokemonInfo(name)
            emit(Resource.Success(response.toDomainModel()))
        } catch (ex: Exception) {
            emit(Resource.Error(ex.message.toString()))
        }
    }

}