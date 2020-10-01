package com.foodie.composetition.data


import com.google.gson.annotations.SerializedName


data class PoiList(

	@SerializedName("poi_id") val poi_id: String,
	@SerializedName("type") val type: String,
	@SerializedName("datasheets") val datasheets: List<Datasheets>
)