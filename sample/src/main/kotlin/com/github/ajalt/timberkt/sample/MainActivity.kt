package com.github.ajalt.timberkt.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.ajalt.timberkt.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var i = 0
        Timber.d {"log ${i++}"}
        Timber.i {"log ${i++}"}
        Timber.w {"log ${i++}"}
        Timber.e {"log ${i++}"}
        Timber.wtf {"log ${i++}"}
    }
}
