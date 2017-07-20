package edu.beretta.ico.data.storage

import io.realm.Realm
import io.realm.RealmConfiguration

object StorageImpl {
    private val SCHEMA_VERSION = 1L
    private val FILE_NAME = "CacheDb"
    private var config: RealmConfiguration

    init {
        config = RealmConfiguration.Builder()
                .name(FILE_NAME)
                .schemaVersion(SCHEMA_VERSION)
                .deleteRealmIfMigrationNeeded()
                .build()
    }

    fun getRealm(): Realm = Realm.getInstance(config)

}