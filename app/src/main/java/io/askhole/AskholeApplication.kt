package io.askhole

import android.app.Application
import com.facebook.stetho.Stetho

class AskholeApplication  : Application() {

    //Stuff to be initialized at application start

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this.applicationContext)}
}