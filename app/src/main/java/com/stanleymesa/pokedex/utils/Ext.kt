package com.stanleymesa.pokedex.utils

import android.util.Log
import com.google.gson.GsonBuilder

fun Int?.orZero(): Int = this ?: 0

fun Boolean?.orFalse(): Boolean = this ?: false

fun loge(message: String) {
    Log.e("TAG", message)
}

fun Any?.toJsonPretty(): String = GsonBuilder().setPrettyPrinting().create().toJson(this)
