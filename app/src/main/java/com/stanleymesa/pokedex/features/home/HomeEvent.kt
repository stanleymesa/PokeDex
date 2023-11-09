package com.stanleymesa.pokedex.features.home

sealed class HomeEvent {
    data class SearchText(val text: String): HomeEvent()
}