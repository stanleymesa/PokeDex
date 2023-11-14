package com.stanleymesa.pokedex.features.home

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.palette.graphics.Palette
import com.stanleymesa.pokedex.domain.usecase.PokemonUseCases
import com.stanleymesa.pokedex.utils.coroutines.CoroutineContextProvider
import com.stanleymesa.pokedex.utils.loge
import com.stanleymesa.pokedex.utils.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val pokemonUseCases: PokemonUseCases,
    private val contextProvider: CoroutineContextProvider
) : ViewModel() {

//    private var _state: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())
//    val state: StateFlow<HomeState> = _state.asStateFlow()

    var state = mutableStateOf(HomeState())
        private set

    var stateSearch = mutableStateOf("")
        private set

    var stateTest = mutableStateOf("")
        private set

    init {
//        getPokemonInfo("charmander")
    }

    fun onEvent(homeEvent: HomeEvent) {
        when (homeEvent) {
            is HomeEvent.SearchText -> {
//                state.value =
//                    state.value.copy(searchText = homeEvent.text)
                stateSearch.value = homeEvent.text
            }

            is HomeEvent.Test -> {
//                state.value = state.value.copy(test = homeEvent.text)
                stateTest.value = homeEvent.text
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

    fun calcDominantColor(drawable: Drawable, onFinish: (Color) -> Unit) {

        val bitmap = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)

        Palette.from(bitmap).generate { palette ->
            palette?.dominantSwatch?.rgb?.let { colorValue ->
                onFinish(Color(colorValue))
            }
        }
    }

}