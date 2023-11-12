package com.stanleymesa.pokedex.utils

import android.util.Log

fun Int?.orZero(): Int = this ?: 0

fun Boolean?.orFalse(): Boolean = this ?: false

fun loge(message: String) {
    Log.e("TAG", message )
}
