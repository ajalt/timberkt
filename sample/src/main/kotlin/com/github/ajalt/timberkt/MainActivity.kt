package com.github.ajalt.timberkt

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (BuildConfig.DEBUG) {
            timber.log.Timber.plant(timber.log.Timber.DebugTree());
        }

        var i = 0
        Timber.d {"log ${i++}"}
        Timber.i {"log ${i++}"}
        Timber.w {"log ${i++}"}
        Timber.e {"log ${i++}"}
        Timber.wtf {"log ${i++}"}
    }
}
