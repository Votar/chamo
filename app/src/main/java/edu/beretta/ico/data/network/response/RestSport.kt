package edu.beretta.ico.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RestSport(
    @SerializedName("id")
    @Expose
    var id: Int?,
    @SerializedName("rating")
    @Expose
    var rating: Int?,
    @SerializedName("title")
    @Expose
    var title: String?,
    @SerializedName("logo")
    @Expose
    var logo: String?,
    @SerializedName("image")
    @Expose
    var image: String?
){
}
