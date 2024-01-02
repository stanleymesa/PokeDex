package com.stanleymesa.pokedex.features.home

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.palette.graphics.Palette
import com.stanleymesa.pokedex.domain.usecase.PokemonUseCases
import com.stanleymesa.pokedex.utils.coroutines.CoroutineContextProvider
import com.stanleymesa.pokedex.utils.loge
import com.stanleymesa.pokedex.utils.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val pokemonUseCases: PokemonUseCases,
    private val contextProvider: CoroutineContextProvider
) : ViewModel() {

    var state = mutableStateOf(HomeState())
        private set

    val pagingData = pokemonUseCases.getPokemonList().cachedIn(viewModelScope)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), PagingData.empty())

    fun onEvent(homeEvent: HomeEvent) {
        when (homeEvent) {
            is HomeEvent.SearchText -> {
                state.value = state.value.copy(searchText = homeEvent.text)
            }

            is HomeEvent.Test -> {
                state.value = state.value.copy(test = homeEvent.text)
            }
        }
    }

    fun getPokemonInfo(name: String) = viewModelScope.launch(contextProvider.io) {
        val data = pokemonUseCases.getPokemonInfo(name)

        data.collect { resource ->
            when (resource) {
                is Resource.Success -> {
                    loge(resource.data.toString())
                }

                else -> {
                    loge(resource.message.toString())
                }
            }
        }
    }

}