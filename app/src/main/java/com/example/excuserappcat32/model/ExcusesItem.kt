package com.example.excuserappcat32.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ExcusesItem(
    @Json(name = "category")
    val category: String?,
    @Json(name = "excuse")
    val excuse: String?,
    @Json(name = "id")
    val id: Int?
)