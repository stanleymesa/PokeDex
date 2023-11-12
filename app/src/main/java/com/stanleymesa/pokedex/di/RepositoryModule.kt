package com.stanleymesa.pokedex.di

import com.stanleymesa.pokedex.data.repository.PokemonRepositoryImpl
import com.stanleymesa.pokedex.domain.repository.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun providePokemonRepository(pokemonRepositoryImpl: PokemonRepositoryImpl): PokemonRepository

}