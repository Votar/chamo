package edu.beretta.ico.data.network.response

import com.google.gson.annotations.SerializedName

data class RestUser
(
        @SerializedName("id")
        var id: Int?,

        @SerializedName("name")
        var name: String?,

        @SerializedName("last_activity")
        var lastActivity: Any?,

        @SerializedName("sports")
        var sports: List<RestSport>?,

        @SerializedName("posts")
        var posts: List<RestPost>?,

        @SerializedName("image")
        var image: String?
) {
}
