package com.example.quiz2soal3_if1_10122022_raihandafaalfarizi.model

import com.google.gson.annotations.SerializedName

data class DataItem(
    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    val biography: Biography,
    val image: Image
)

data class Biography(
    @SerializedName("full-name")
    val fullName: String
)

data class Image(
    val url: String
)