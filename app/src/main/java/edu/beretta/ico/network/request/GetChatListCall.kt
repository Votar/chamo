package edu.beretta.ico.network.request

import edu.beretta.ico.network.RestClient
import edu.beretta.ico.network.ApiContract
import edu.beretta.ico.data.network.response.RestChat
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

class GetChatListCall() {
    companion object {
        const val END_POINT = "api/chat/get-chats"
    }

    interface Request {
        @FormUrlEncoded
        @POST(END_POINT)

        fun parameters(@Header(ApiContract.AUTH_HEADER) token: String,
                       @Field("limit") limit: Int?,
                       @Field("offset") offset: Int?): Call<List<RestChat>>
    }

    fun create(token: String,
               limit: Int,
               offset: Int
    ) = RestClient.get().create(Request::class.java).parameters(token, limit, offset)


}