package com.stanleymesa.pokedex.features.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stanleymesa.pokedex.domain.usecase.PokemonUseCases
import com.stanleymesa.pokedex.utils.coroutines.CoroutineContextProvider
import com.stanleymesa.pokedex.utils.loge
import com.stanleymesa.pokedex.utils.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val pokemonUseCases: PokemonUseCases,
    private val contextProvider: CoroutineContextProvider
) : ViewModel() {

    private var _state = mutableStateOf(HomeState())

    val state: State<HomeState> = _state

    init {
        getPokemonInfo("charmander")
    }

    fun onEvent(homeEvent: HomeEvent) {
        when (homeEvent) {
            is HomeEvent.SearchText -> {
                _state.value = state.value.copy(searchText = homeEvent.text)
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