package com.stanleymesa.pokedex.features.home

sealed class HomeEvent {
    data class SearchText(val text: String): HomeEvent()
    data class Test(val text: String): HomeEvent()
}