package edu.beretta.ico.network.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Sport(
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
