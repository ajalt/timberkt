package com.github.ajalt.timberkt

import android.util.Log
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

data class Msg(val priority: Int, val tag: String?, val message: String?, val t: Throwable?)

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class TimberKtTest {
    @Before @After fun setup() {
        Timber.uprootAll()
    }

    @Test
    fun logMessages() {
        val messages = mutableListOf<Msg>()
        Timber.plant(object : timber.log.Timber.DebugTree() {
            override fun log(priority: Int, tag: String?, message: String?, t: Throwable?) {
                messages.add(Msg(priority, tag, message, t))
            }
        })

        v { "Verbose" }
        Timber.v { "Verbose" }
        Timber.tag("Custom").v { "Verbose" }
        d { "Debug" }
        Timber.d { "Debug" }
        Timber.tag("Custom").d { "Debug" }
        i { "Info" }
        Timber.i { "Info" }
        Timber.tag("Custom").i { "Info" }
        w { "Warn" }
        Timber.w { "Warn" }
        Timber.tag("Custom").w { "Warn" }
        e { "Error" }
        Timber.e { "Error" }
        Timber.tag("Custom").e { "Error" }
        wtf { "Assert" }
        Timber.wtf { "Assert" }
        Timber.tag("Custom").wtf { "Assert" }

        assertThat(messages).containsExactly(
                Msg(Log.VERBOSE, "TimberKtTest", "Verbose", null),
                Msg(Log.VERBOSE, "TimberKtTest", "Verbose", null),
                Msg(Log.VERBOSE, "Custom", "Verbose", null),
                Msg(Log.DEBUG, "TimberKtTest", "Debug", null),
                Msg(Log.DEBUG, "TimberKtTest", "Debug", null),
                Msg(Log.DEBUG, "Custom", "Debug", null),
                Msg(Log.INFO, "TimberKtTest", "Info", null),
                Msg(Log.INFO, "TimberKtTest", "Info", null),
                Msg(Log.INFO, "Custom", "Info", null),
                Msg(Log.WARN, "TimberKtTest", "Warn", null),
                Msg(Log.WARN, "TimberKtTest", "Warn", null),
                Msg(Log.WARN, "Custom", "Warn", null),
                Msg(Log.ERROR, "TimberKtTest", "Error", null),
                Msg(Log.ERROR, "TimberKtTest", "Error", null),
                Msg(Log.ERROR, "Custom", "Error", null),
                Msg(Log.ASSERT, "TimberKtTest", "Assert", null),
                Msg(Log.ASSERT, "TimberKtTest", "Assert", null),
                Msg(Log.ASSERT, "Custom", "Assert", null)
        )
    }

    @Test
    fun logExceptions() {
        val messages = mutableListOf<Msg>()
        Timber.plant(object : timber.log.Timber.DebugTree() {
            override fun log(priority: Int, tag: String?, message: String?, t: Throwable?) {
                // Timber appends the error traceback to the message, so don't examine it
                messages.add(Msg(priority, tag, null, t))
            }
        })

        val e = Exception("e")

        v(e)
        v(e) { "Verbose" }
        Timber.v(e)
        Timber.v(e) { "Verbose" }
        Timber.tag("Custom").v(e) { "Verbose" }
        d(e)
        d(e) { "Debug" }
        Timber.d(e)
        Timber.d(e) { "Debug" }
        Timber.tag("Custom").d(e) { "Debug" }
        i(e)
        i(e) { "Info" }
        Timber.i(e)
        Timber.i(e) { "Info" }
        Timber.tag("Custom").i(e) { "Info" }
        w(e)
        w(e) { "Warn" }
        Timber.w(e)
        Timber.w(e) { "Warn" }
        Timber.tag("Custom").w(e) { "Warn" }
        e(e)
        e(e) { "Error" }
        Timber.e(e)
        Timber.e(e) { "Error" }
        Timber.tag("Custom").e(e) { "Error" }
        wtf(e)
        wtf(e) { "Assert" }
        Timber.wtf(e)
        Timber.wtf(e) { "Assert" }
        Timber.tag("Custom").wtf(e) { "Assert" }

        assertThat(messages).containsExactly(
                Msg(Log.VERBOSE, "TimberKtTest", null, e),
                Msg(Log.VERBOSE, "TimberKtTest", null, e),
                Msg(Log.VERBOSE, "TimberKtTest", null, e),
                Msg(Log.VERBOSE, "TimberKtTest", null, e),
                Msg(Log.VERBOSE, "Custom", null, e),
                Msg(Log.DEBUG, "TimberKtTest", null, e),
                Msg(Log.DEBUG, "TimberKtTest", null, e),
                Msg(Log.DEBUG, "TimberKtTest", null, e),
                Msg(Log.DEBUG, "TimberKtTest", null, e),
                Msg(Log.DEBUG, "Custom", null, e),
                Msg(Log.INFO, "TimberKtTest", null, e),
                Msg(Log.INFO, "TimberKtTest", null, e),
                Msg(Log.INFO, "TimberKtTest", null, e),
                Msg(Log.INFO, "TimberKtTest", null, e),
                Msg(Log.INFO, "Custom", null, e),
                Msg(Log.WARN, "TimberKtTest", null, e),
                Msg(Log.WARN, "TimberKtTest", null, e),
                Msg(Log.WARN, "TimberKtTest", null, e),
                Msg(Log.WARN, "TimberKtTest", null, e),
                Msg(Log.WARN, "Custom", null, e),
                Msg(Log.ERROR, "TimberKtTest", null, e),
                Msg(Log.ERROR, "TimberKtTest", null, e),
                Msg(Log.ERROR, "TimberKtTest", null, e),
                Msg(Log.ERROR, "TimberKtTest", null, e),
                Msg(Log.ERROR, "Custom", null, e),
                Msg(Log.ASSERT, "TimberKtTest", null, e),
                Msg(Log.ASSERT, "TimberKtTest", null, e),
                Msg(Log.ASSERT, "TimberKtTest", null, e),
                Msg(Log.ASSERT, "TimberKtTest", null, e),
                Msg(Log.ASSERT, "Custom", null, e)
        )
    }

    @Test
    fun lazyMessage_noTree() {
        var i = 0

        d { "${i++}" }
        Timber.d { "${i++}" }
        Timber.tag("Custom").d { "${i++}" }

        assertThat(i).isEqualTo(0)
    }

    @Test
    fun lazyMessage_tree() {
        Timber.plant(timber.log.Timber.DebugTree())
        var i = 0

        d { "${i++}" }
        Timber.d { "${i++}" }
        Timber.tag("Custom").d { "${i++}" }

        assertThat(i).isEqualTo(3)
    }
}
