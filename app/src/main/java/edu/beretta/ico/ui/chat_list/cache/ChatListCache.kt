package edu.beretta.ico.ui.chat_list.cache

import edu.beretta.ico.data.network.response.RestChat
import edu.beretta.ico.data.storage.StorageImpl
import edu.beretta.ico.data.storage.models.RealmChat
import edu.beretta.ico.ui.chat_list.converters.toRealmChat
import java.util.*


class ChatListCache(useColdCache: Boolean) {
    val EXPIRE_TIME = 10 * 60 * 1000 // 10 min
    var lastUpdate: Long

    init {
        //TODO : Find solution to store lastUpdate time without preferences
        if (useColdCache)
            lastUpdate = Calendar.getInstance().timeInMillis
        else
            lastUpdate = -1
    }

    fun isCached(): Boolean {
        val realm = StorageImpl.getRealm()
        val realmResult = realm.where(RealmChat::class.java).findAll()
        return realmResult != null && realmResult.count() > 0
    }

    fun isExpired(): Boolean {
        val currentTime = Calendar.getInstance().timeInMillis
        return (currentTime - lastUpdate > EXPIRE_TIME)
    }


    fun get(): List<RealmChat> {
        val realm = StorageImpl.getRealm()
        val realmResult = realm.where(RealmChat::class.java).findAll()
        try {
            if (realmResult == null)
                return emptyList()
            else {
                val chatListSnapshot = realm.copyFromRealm(realmResult)
                //map RealmResult to List
                return List<RealmChat>(realmResult.size, { chatListSnapshot[it] })
            }
        } finally {
            realm.close()
        }


    }

    fun put(dataset: List<RestChat>) {
        val realm = StorageImpl.getRealm()
        realm.executeTransaction {
            realm.where(RealmChat::class.java)
                    .findAll()
                    .deleteAllFromRealm()
        }
        val realmChats = dataset.toRealmChat()
        realmChats.forEach {
            realm.executeTransaction {
                db ->
                db.insert(it)
            }
        }

        lastUpdate = Calendar.getInstance().timeInMillis
        realm.close()
    }
}