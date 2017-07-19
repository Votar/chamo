package edu.beretta.ico.network.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LastMessage(
        @SerializedName("type")
        @Expose
        var type: Int?,
        @SerializedName("request_id")
        @Expose
        var requestId: String?,
        @SerializedName("message")
        @Expose
        var message: Message?
) {
}
