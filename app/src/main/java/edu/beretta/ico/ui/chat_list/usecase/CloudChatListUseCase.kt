package edu.beretta.ico.ui.chat_list.usecase

import edu.beretta.ico.data.network.response.RestChat
import edu.beretta.ico.network.request.GetChatListCall
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CloudChatListUseCase(
        val listener: ResponseListener,
        val token: String,
        val limit: Int = 10,
        val offset: Int = 0) {

    interface ResponseListener {
        fun onSuccess(chats: List<RestChat>)
        fun onFailure(code: Int?, message: String?)
    }

    fun request() {
        GetChatListCall().create(token, limit, offset)
                .enqueue(object : Callback<List<RestChat>> {
                    override fun onResponse(call: Call<List<RestChat>>, response: Response<List<RestChat>>) {
                        if (response.isSuccessful)
                            listener.onSuccess(response.body())
                        else
                            listener.onFailure(response.code(), response.errorBody().string())
                    }

                    override fun onFailure(call: Call<List<RestChat>>?, t: Throwable?) {
                        //TODO : parse exceptions
                        listener.onFailure(null, null)
                    }
                })
    }
}