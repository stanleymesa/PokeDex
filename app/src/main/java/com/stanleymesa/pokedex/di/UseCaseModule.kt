package com.stanleymesa.pokedex.di

import com.stanleymesa.pokedex.domain.repository.PokemonRepository
import com.stanleymesa.pokedex.domain.usecase.GetPokemonInfo
import com.stanleymesa.pokedex.domain.usecase.GetPokemonList
import com.stanleymesa.pokedex.domain.usecase.PokemonUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun providePokemonUseCases(
        pokemonRepository: PokemonRepository
    ): PokemonUseCases = PokemonUseCases(
        getPokemonInfo = GetPokemonInfo(pokemonRepository),
        getPokemonList = GetPokemonList(pokemonRepository)
    )
}