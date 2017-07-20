package edu.beretta.ico.ui.chat_list.usecase

import edu.beretta.ico.data.network.response.RestChat
import edu.beretta.ico.data.storage.models.RealmChat
import edu.beretta.ico.ui.chat_list.cache.ChatListCache
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import org.jetbrains.anko.coroutines.experimental.bg

class ChatListUseCase(
        val listener: ChatListCallBack,
        val token: String,
        val limit: Int = 10,
        val offset: Int = 0) {
    interface ChatListCallBack {
        fun onSuccess(chats: List<RealmChat>)
        fun onFailure(code: Int?, message: String?)
    }

    val chatListCache = ChatListCache()

    fun request() {
        if (chatListCache.isCached() && chatListCache.isExpired().not())
            listener.onSuccess(chatListCache.get())
        else
            CloudChatListUseCase(responseListener, token, limit, offset).request()
    }

    val responseListener = object : CloudChatListUseCase.ResponseListener {
        override fun onSuccess(chats: List<RestChat>) {
            launch(UI) {
                val async: Deferred<List<RealmChat>> = bg {
                    chatListCache.put(chats)
                    chatListCache.get()
                }
                listener.onSuccess(async.await())
            }


        }

        override fun onFailure(code: Int?, message: String?) {
            listener.onFailure(code, message)
        }
    }
}