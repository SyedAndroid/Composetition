package com.foodie.composetition.data

import com.google.gson.annotations.SerializedName


data class RestaurantResponse(

    @SerializedName("searchInfos") val searchInfos: SearchInfos,
    @SerializedName("poiList") val poiList: List<PoiList>
)