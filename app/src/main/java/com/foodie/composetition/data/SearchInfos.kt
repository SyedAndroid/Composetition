package com.foodie.composetition.data

import com.google.gson.annotations.SerializedName


data class SearchInfos(

    @SerializedName("QTime") val qTime: Int,
    @SerializedName("lang") val lang: String,
    @SerializedName("numFound") val numFound: Int,
    @SerializedName("start") val start: Int,
    @SerializedName("status") val status: Int
)