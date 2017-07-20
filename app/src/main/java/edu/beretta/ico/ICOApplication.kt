package edu.beretta.ico

import android.app.Application
import io.realm.Realm

/**
 * Created by beretta on 20.07.2017.
 */
class ICOApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(applicationContext)
    }
}