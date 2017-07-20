package edu.beretta.ico.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RestMessage(
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
        var from: RestUser?,
//        @SerializedName("data")
//        @Expose
//        var data: RestAudioData?,
        @SerializedName("date")
        @Expose
        var date: Int?
) {
}
