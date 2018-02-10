package com.github.ajalt.timberkt.sample

import android.app.Application
import com.github.ajalt.timberkt.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
