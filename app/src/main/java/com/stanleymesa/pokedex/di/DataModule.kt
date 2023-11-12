package com.stanleymesa.pokedex.di

import com.stanleymesa.pokedex.BuildConfig.BASE_URL
import com.stanleymesa.pokedex.data.remote.PokemonRemoteService
import com.stanleymesa.pokedex.domain.repository.PokemonRepository
import com.stanleymesa.pokedex.domain.usecase.GetPokemonInfo
import com.stanleymesa.pokedex.domain.usecase.PokemonUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient =
        OkHttpClient().newBuilder().connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true).build()

    @Singleton
    @Provides
    fun providePokemonRemoteService(
        client: OkHttpClient
    ): PokemonRemoteService = Retrofit.Builder()
        .client(client)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(PokemonRemoteService::class.java)

}