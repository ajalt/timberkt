package com.github.ajalt.timberkt.sample

import android.app.Activity
import com.github.ajalt.timberkt.*


class MainActivity : Activity() {
    override fun onResume() {
        super.onResume()

        var i = 0

        Timber.d { "log ${i++}" }
        Timber.i { "log ${i++}" }
        Timber.w { "log ${i++}" }
        Timber.e { "log ${i++}" }
        Timber.wtf { "log ${i++}" }

        Timber.tag("Custom tag").d { "log ${i++}" }
        Timber.tag("Custom tag").i { "log ${i++}" }
        Timber.tag("Custom tag").w { "log ${i++}" }
        Timber.tag("Custom tag").e { "log ${i++}" }
        Timber.tag("Custom tag").wtf { "log ${i++}" }

        d { "log ${i++}" }
        i { "log ${i++}" }
        w { "log ${i++}" }
        e { "log ${i++}" }
        wtf { "log ${i++}" }
    }
}
