package com.foodie.composetition.data


import com.google.gson.annotations.SerializedName

data class Datasheets(

    @SerializedName("dts_id") val dtsId: Long,
    @SerializedName("description") val description: String,
    @SerializedName("name") val name: String,
    @SerializedName("latitude") val latitude: Double,
    @SerializedName("longitude") val longitude: Double,
    @SerializedName("country") val country: String,
    @SerializedName("area") val area: String,
    @SerializedName("city") val city: String,
    @SerializedName("address") val address: String,
    @SerializedName("postcode") val postcode: String,
    @SerializedName("price_range") val price_range: String,
    @SerializedName("email") val email: String,
    @SerializedName("michelin_guide_selection") val michelinGuideSelection: Int,
    @SerializedName("michelin_stars") val michelinStars: Int,
    @SerializedName("medias") val medias: List<Medias>
)