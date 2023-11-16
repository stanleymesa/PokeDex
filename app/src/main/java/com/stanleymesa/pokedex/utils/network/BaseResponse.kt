package com.stanleymesa.pokedex.utils.network

import com.google.gson.annotations.SerializedName

data class BaseListResponse<T>(
    @field:SerializedName("next")
    val next: String? = null,
    @field:SerializedName("previous")
    val previous: String? = null,
    @field:SerializedName("count")
    val count: Int? = null,
    @field:SerializedName("results")
    val data: List<T?>? = null
)