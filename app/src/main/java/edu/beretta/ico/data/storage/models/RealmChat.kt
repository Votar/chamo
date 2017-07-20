package edu.beretta.ico.data.storage.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RealmChat() : RealmObject() {

    @PrimaryKey
    var id: Long? = null
    var title: String? = null

    object Fields {
        const val id = "id"
    }

    override fun toString(): String {
        return "RealmChat(id=$id, title='$title')"
    }


}
