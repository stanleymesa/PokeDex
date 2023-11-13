package com.stanleymesa.pokedex.utils

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.StateFlow

fun Int?.orZero(): Int = this ?: 0

fun Boolean?.orFalse(): Boolean = this ?: false

fun loge(message: String) {
    Log.e("TAG", message)
}

@Composable
fun <T> StateFlow<T>.asState(): T = this.collectAsStateWithLifecycle().value
