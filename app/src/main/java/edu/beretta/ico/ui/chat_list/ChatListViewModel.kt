package edu.beretta.ico.ui.chat_list

import android.util.Log
import edu.beretta.ico.arch.viewmodel.BaseArchViewModel
import edu.beretta.ico.network.models.response.RestChat
import edu.beretta.ico.network.request.GetChatListRequest

class ChatListViewModel : BaseArchViewModel<ChatListContract.View>(), ChatListContract.ViewModel {

    override fun refreshChats() {
        requestChats()
    }

    private fun requestChats() {
        //TODO : Remove test data
        val token = "a7dcef3623f0b976e890ffb77ac2b7d4"
        GetChatListRequest(getChatListResponseListener).execute(token)
    }

    private val getChatListResponseListener = object : GetChatListRequest.ChatsResponseListener {
        override fun onSuccessGetTables(chats: List<RestChat>) {
            
        }

        override fun onFailureGetTables(code: Int?, message: String?) {

        }
    }


}