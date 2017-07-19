package edu.beretta.ico.network.request

import edu.beretta.ico.network.RestClient
import edu.beretta.ico.network.models.ApiContract
import edu.beretta.ico.network.models.response.RestChat
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

class GetChatListRequest(val listener: ChatsResponseListener) {
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

    interface ChatsResponseListener {
        fun onSuccessGetTables(chats: List<RestChat>)
        fun onFailureGetTables(code: Int?, message: String?)
    }

    val rest: Request by lazy { RestClient.get().create(Request::class.java) }

    fun execute(token: String,
                limit: Int = 2,
                offset: Int = 0
    ) {
        async(UI) {
            try {
                val data: Deferred<Response<List<RestChat>>> = bg {
                    rest.parameters(token, limit, offset).execute()
                }
                parse(data.await())
            }catch (ext : Exception){
                ext.printStackTrace()
            }
        }
    }

    fun parse(response: Response<List<RestChat>>) {
        if (response.isSuccessful)
            listener.onSuccessGetTables(response.body())
        else
            listener.onFailureGetTables(response.code(), response.errorBody().string())
    }


}