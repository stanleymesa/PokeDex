package com.stanleymesa.pokedex.di

import com.stanleymesa.pokedex.utils.coroutines.CoroutineContextProvider
import com.stanleymesa.pokedex.utils.coroutines.CoroutineContextProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideCoroutineContextProvider(coroutineContextProviderImpl: CoroutineContextProviderImpl): CoroutineContextProvider =
        coroutineContextProviderImpl

}