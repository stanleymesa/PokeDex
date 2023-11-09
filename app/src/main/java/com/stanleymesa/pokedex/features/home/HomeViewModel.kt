package com.stanleymesa.pokedex.features.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _state: MutableState<HomeState> by lazy {
        mutableStateOf(HomeState())
    }
    val state: State<HomeState> = _state

    fun onEvent(homeEvent: HomeEvent) {
        when (homeEvent) {
            is HomeEvent.SearchText -> {
                _state.value = state.value.copy(searchText = homeEvent.text)
            }
        }
    }

}