package edu.beretta.ico.network.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User
(
        @SerializedName("id")
        var id: Int?,

        @SerializedName("name")
        var name: String?,

        @SerializedName("last_activity")
        var lastActivity: Any?,

        @SerializedName("sports")
        var sports: List<Sport>?,

        @SerializedName("posts")
        var posts: List<Post>?,

        @SerializedName("image")
        var image: String?
) {
}
