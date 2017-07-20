package edu.beretta.ico.ui.chat_list.converters

import edu.beretta.ico.data.network.response.RestChat
import edu.beretta.ico.data.storage.models.RealmChat

fun List<RestChat>.toRealmChat(): List<RealmChat> {
    return this
            .filter { it.id != null && it.title != null }
            .map {
                val result = RealmChat()
                result.id = it.id
                result.title = it.title
                result
            }
}
