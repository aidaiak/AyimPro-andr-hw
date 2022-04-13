package com.aid.ayimpro_andr_hw

import com.google.gson.annotations.SerializedName

data class Response(
    val results: MutableList<Item>
)

data class Item(
    val id: Long?,
    val name: String?,
    val status: String,
    val species: String?,
    val type: String?,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String?
)

data class Location(
    val name: String,
    val url: String?
)

data class Origin(
    val name: String,
    val url: String?
)