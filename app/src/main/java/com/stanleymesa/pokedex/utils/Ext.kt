package com.stanleymesa.pokedex.utils

fun Int?.orZero(): Int = this ?: 0

fun Boolean?.orFalse(): Boolean = this ?: false
