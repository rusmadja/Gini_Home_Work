package com.reouven.app_using_api_in_view.model

import com.squareup.moshi.Json


data class Number(
    @Json(name = "number")
    val number: Int,
    var flag: Boolean = false
)