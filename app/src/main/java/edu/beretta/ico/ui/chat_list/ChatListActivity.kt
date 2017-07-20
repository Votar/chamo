package edu.beretta.ico.ui.chat_list

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.View
import edu.beretta.ico.R
import edu.beretta.ico.arch.view.BaseArchActivity
import edu.beretta.ico.data.storage.models.RealmChat
import kotlinx.android.synthetic.main.activity_chat_list.*

class ChatListActivity : BaseArchActivity<ChatListContract.View, ChatListViewModel>(),
        ChatListContract.View {


    override val rootView: View by lazy { a_chat_list_root }

    override val mViewModel: ChatListViewModel by lazy { ViewModelProviders.of(this).get(ChatListViewModel::class.java) }

    val TAG = "ChatListActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_list)
    }

    override fun onStart() {
        super.onStart()
        bindObservers()
    }


    override fun onStop() {
        super.onStop()
        unbindObservers()
    }

    private fun bindObservers() {
        mViewModel.chatList.observe(this, chatListObserver)
    }

    private fun unbindObservers() {
        mViewModel.chatList.removeObserver(chatListObserver)
    }

    private val chatListObserver = Observer<List<RealmChat>> {
        it?.let {
            it.forEach {
                Log.d(TAG,it.toString())
            }
        }
    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }
}
