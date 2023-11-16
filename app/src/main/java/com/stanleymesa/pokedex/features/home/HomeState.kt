package com.stanleymesa.pokedex.features.home

import androidx.compose.ui.graphics.Color

data class HomeState(
    var searchText: String = "",
    var test: String = "",
    var dominantColor: Color = Color.LightGray,
)
