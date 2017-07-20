package edu.beretta.ico.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RestLastMessage(
        @SerializedName("type")
        @Expose
        var type: Int?,
        @SerializedName("request_id")
        @Expose
        var requestId: String?,
        @SerializedName("message")
        @Expose
        var message: RestMessage?
) {
}
