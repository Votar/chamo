package edu.beretta.ico.ui.chat_list

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import edu.beretta.ico.R
import edu.beretta.ico.arch.view.BaseArchActivity
import edu.beretta.ico.data.storage.models.RealmChat
import edu.beretta.ico.ui.chat_list.adapter.ChatListAdapter
import kotlinx.android.synthetic.main.activity_chat_list.*
import android.support.v7.widget.DividerItemDecoration


class ChatListActivity : BaseArchActivity<ChatListContract.View, ChatListViewModel>(),
        ChatListContract.View {
    companion object {
        const val  KEY_RESTORE ="out_k_restore"
    }


    override val rootView: View by lazy { a_chat_list_root }

    override val mViewModel: ChatListViewModel by lazy { ViewModelProviders.of(this).get(ChatListViewModel::class.java) }

    val TAG = "ChatListActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_list)
        //TODO :add refresh function
    }

    override fun onStart() {
        super.onStart()
        setupLayouts()
        bindObservers()

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putBoolean(KEY_RESTORE, true)
        super.onSaveInstanceState(outState)
    }
    override fun onStop() {
        super.onStop()
        unbindObservers()
    }

    fun setupLayouts() {
        a_chat_list_recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        a_chat_list_recycler.adapter = ChatListAdapter()
        val dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        a_chat_list_recycler.addItemDecoration(dividerItemDecoration)
        a_chat_list_refresh.setOnRefreshListener { mViewModel.refreshChats() }
    }

    private fun bindObservers() {
        mViewModel.chatList.observe(this, chatListObserver)
        mViewModel.progressState.observe(this, progressObserver)
    }

    private fun unbindObservers() {
        mViewModel.chatList.removeObserver(chatListObserver)
        mViewModel.progressState.removeObserver(progressObserver)
    }

    private val chatListObserver = Observer<List<RealmChat>> {
        it?.let {
            (a_chat_list_recycler.adapter as ChatListAdapter).swapData(it)
        }
    }

    private val progressObserver = Observer<Boolean> {
        it?.let {
            a_chat_list_refresh.isRefreshing = it
        }
    }

}
