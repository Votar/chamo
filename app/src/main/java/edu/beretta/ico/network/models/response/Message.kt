package edu.beretta.ico.network.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Message(
        @SerializedName("id")
        @Expose
        var id: Int?,
        @SerializedName("room_id")
        @Expose
        var roomId: Int?,
        @SerializedName("status")
        @Expose
        var status: Int?,
        @SerializedName("type")
        @Expose
        var type: Int?,
        @SerializedName("from")
        @Expose
        var from: User?,
//        @SerializedName("data")
//        @Expose
//        var data: AudioData?,
        @SerializedName("date")
        @Expose
        var date: Int?
) {
}
