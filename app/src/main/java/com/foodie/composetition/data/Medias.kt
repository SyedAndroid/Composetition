package com.foodie.composetition.data

import com.google.gson.annotations.SerializedName


data class Medias(

    @SerializedName("type") val type: String,
    @SerializedName("identifier") val identifier: String,
    @SerializedName("copyright") val copyright: String,
    @SerializedName("media_representative") val media_representative: Int,
    @SerializedName("url_xl") val url_xl: String,
    @SerializedName("url_s") val url_s: String,
    @SerializedName("author") val author: String,
    @SerializedName("media_orientation") val media_orientation: Int,
    @SerializedName("url_l") val url_l: String,
    @SerializedName("url") val url: String,
    @SerializedName("media") val media: List<String>
)