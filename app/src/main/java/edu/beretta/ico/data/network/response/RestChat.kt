package edu.beretta.ico.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RestChat(@SerializedName("id")
                    var id: Long?,
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
                    var author: Long?,
                    @SerializedName("image")
                    var image: String?,
                    @SerializedName("unread")
                    var unread: Int?,
                    @SerializedName("users")
                    var users: List<RestUser>?,
                    @SerializedName("last_message")
                    @Expose
                    var lastMessage: RestLastMessage?
) {





}
