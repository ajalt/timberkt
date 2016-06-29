package com.github.ajalt.timberkt.sample

import android.app.Application
import com.github.ajalt.timberkt.BuildConfig
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree());
        }
    }
}
