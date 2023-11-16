package com.stanleymesa.pokedex.features.home.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.stanleymesa.pokedex.data.mapper.PokemonListMapper.toDomainModel
import com.stanleymesa.pokedex.data.remote.PokemonRemoteDataSource
import com.stanleymesa.pokedex.domain.model.PokemonList

class PokemonPagingSource(
    private val pokemonRemoteDataSource: PokemonRemoteDataSource
) : PagingSource<Int, PokemonList>() {
    override fun getRefreshKey(state: PagingState<Int, PokemonList>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonList> {
        return try {
            val pageSize = params.loadSize
            val page = params.key ?: 0

            val response = pokemonRemoteDataSource.getPokemonList(
                limit = pageSize,
                offset = pageSize * page
            )

            if (response.data != null) {
                LoadResult.Page(
                    data = response.data.map {
                        it.toDomainModel()
                    },
                    prevKey = null,
                    nextKey = if (response.next.isNullOrEmpty()) null else page.plus(1)
                )
            } else {
                LoadResult.Error(Throwable(message = "data is empty"))
            }

        } catch (ex: Exception) {
            LoadResult.Error(ex)
        }
    }
}