package edu.beretta.ico.ui.chat_list.adapter

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import edu.beretta.ico.R
import edu.beretta.ico.data.storage.models.RealmChat

class ChatListAdapter : RecyclerView.Adapter<ViewHolder>() {
    var dataset: List<RealmChat>

    init {
        dataset = emptyList()
    }
    fun swapData(newList: List<RealmChat>) {
        if (dataset.isEmpty()) {
            /*
             * notifyDataSetChanged() - it's a magic to work around with
              * IndexOutOfBoundsException: Inconsistency detected. Invalid item position
             * Without this line after leaving app for example to Home and back, Activity  not
             * destroying, it returns in onStart() and I don't know why it always crash with
             *IndexOutOfBoundsException: Inconsistency detected. Invalid item position 0(offset:10).state:10 android.support.v7.widget.RecyclerView{f09a21a VFED..... .F....ID 0,0-1080,1731 #7f0b006c app:id/a_chat_list_recycler}, adapter:edu.beretta.ico.ui.chat_list.adapter.ChatListAdapter@9a214b, layout:android.support.v7.widget.LinearLayoutManager@2c73728, context:edu.beretta.ico.ui.chat_list.ChatListActivity@8b4e268
             * after couple of hours in research, I found several solution and stopped on this
             */
            notifyDataSetChanged()
            dataset = newList
            notifyItemRangeInserted(0, newList.size)
        } else {
            val diffResult = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
                override fun getOldListSize(): Int {
                    return dataset.size
                }

                override fun getNewListSize(): Int {
                    return newList.size
                }

                override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    val old = dataset[oldItemPosition]
                    val comment = newList[newItemPosition]
                    return old.id == comment.id
                }

                override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    val old = dataset[oldItemPosition]
                    val chat = newList[newItemPosition]
                    return old.id == chat.id
                            && old.title == chat.title
                }
            })
            dataset = newList
            diffResult.dispatchUpdatesTo(this)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        dataset.let {
            val nextItem = it[position]
            holder.title.text = nextItem.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_chat_list_item, parent, false)

        return ViewHolder(view,
                view.findViewById<TextView>(R.id.chat_list_item_title)
        )
    }

    override fun getItemCount(): Int = dataset.count()

}

class ViewHolder(val rootView: View,
                 val title: TextView) : RecyclerView.ViewHolder(rootView) {


}