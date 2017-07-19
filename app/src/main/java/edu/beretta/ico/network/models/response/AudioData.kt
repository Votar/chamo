package edu.beretta.ico.network.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AudioData(
    @SerializedName("url")
    var url: String?,
    @SerializedName("act")
    @Expose
    var act: String?,
    @SerializedName("duration")
    @Expose
    var duration: String?){
}
