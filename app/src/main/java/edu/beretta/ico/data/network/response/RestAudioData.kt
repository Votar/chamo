package edu.beretta.ico.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RestAudioData(
    @SerializedName("url")
    var url: String?,
    @SerializedName("act")
    @Expose
    var act: String?,
    @SerializedName("duration")
    @Expose
    var duration: String?){
}
