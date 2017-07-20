package edu.beretta.ico.ui.chat_list

import android.arch.lifecycle.MutableLiveData
import edu.beretta.ico.arch.viewmodel.BaseArchViewModel
import edu.beretta.ico.data.network.response.RestChat
import edu.beretta.ico.data.storage.models.RealmChat
import edu.beretta.ico.network.request.GetChatListCall
import edu.beretta.ico.ui.chat_list.usecase.ChatListUseCase

class ChatListViewModel : BaseArchViewModel<ChatListContract.View>(), ChatListContract.ViewModel {

    private val getChatListResponseListener: ChatListUseCase.ChatListCallBack
    val chatList = MutableLiveData<List<RealmChat>>()
    val progressState = MutableLiveData<Boolean>()
    val token = "a7dcef3623f0b976e890ffb77ac2b7d4"

    init {
        //TODO: Find way to inject token
        getChatListResponseListener = object : ChatListUseCase.ChatListCallBack {
            override fun onSuccess(chats: List<RealmChat>) {
                progressState.value = false
                chatList.value = chats
            }

            override fun onFailure(code: Int?, message: String?) {
                progressState.value = false
                mView?.showError(message)
            }
        }
    }

    val chatListUseCase = ChatListUseCase(getChatListResponseListener, token)

    override fun attachView(view: ChatListContract.View) {
        super.attachView(view)
        requestChats()
    }

    override fun detachView() {
        super.detachView()
        chatList.value = null
    }

    override fun refreshChats() {
        progressState.value = true
        chatListUseCase.fetch()
    }

    private fun requestChats() {
        progressState.value = true
        chatListUseCase.request()
    }


}