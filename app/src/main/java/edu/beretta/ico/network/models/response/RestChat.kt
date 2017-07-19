package edu.beretta.ico.network.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RestChat(@SerializedName("id")
                    var id: Int?,
                    @SerializedName("title")
                    var title: String?,
                    @SerializedName("status")
                    var status: Int?,
                    @SerializedName("sport_id")
                    var sportId: Long?,
                    @SerializedName("type")
                    var type: Int?,
                    @SerializedName("created")
                    var created: Int?,
                    @SerializedName("author")
                    var author: Int?,
                    @SerializedName("image")
                    var image: String?,
                    @SerializedName("unread")
                    var unread: Int?,
                    @SerializedName("users")
                    var users: List<User>?,
                    @SerializedName("last_message")
                    @Expose
                    var lastMessage: LastMessage?
) {





}
