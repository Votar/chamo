package edu.beretta.ico.ui.chat_list

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import edu.beretta.ico.R
import edu.beretta.ico.arch.view.BaseArchActivity
import kotlinx.android.synthetic.main.activity_chat_list.*

class ChatListActivity : BaseArchActivity<ChatListContract.View, ChatListViewModel>(),
        ChatListContract.View {
    override val rootView: View by lazy { a_chat_list_root }

    override val mViewModel: ChatListViewModel by lazy { ViewModelProviders.of(this).get(ChatListViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_list)
    }

    override fun onStart() {
        super.onStart()
        mViewModel.refreshChats()
    }
}
