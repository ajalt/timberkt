package com.github.ajalt.timberkt

import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class TimberKtTest {
    @Before @After fun setup() {
        Timber.uprootAll();
    }

    @Test
    fun lazyMessage_noTree() {
        var i = 0

        d { "${i++}" };
        Timber.d { "${i++}" };
        Timber.tag("Custom").d { "${i++}" };

        assertThat(i).isEqualTo(0)
    }

    @Test
    fun lazyMessage_tree() {
        Timber.plant(timber.log.Timber.DebugTree())
        var i = 0

        d { "${i++}" };
        Timber.d { "${i++}" };
        Timber.tag("Custom").d { "${i++}" };

        assertThat(i).isEqualTo(3)
    }
}
