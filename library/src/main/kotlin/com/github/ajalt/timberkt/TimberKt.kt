@file:Suppress("NOTHING_TO_INLINE") // Inline anyway to allow tag reflection to work

package com.github.ajalt.timberkt

import timber.log.Timber

//
// Static methods on the Timber object
//

object Timber {
    /** Log a verbose message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun v(noinline message: () -> String) = Timber.v("%s", LazyString(message))

    /** Log a verbose exception and a message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun v(t: Throwable, noinline message: () -> String) = Timber.v(t, "%s", LazyString(message))

    /** Log a debug message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun d(noinline message: () -> String) = Timber.d("%s", LazyString(message))

    /** Log a debug exception and a message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun d(t: Throwable, noinline message: () -> String) = Timber.d(t, "%s", LazyString(message))

    /** Log an info message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun i(noinline message: () -> String) = Timber.i("%s", LazyString(message))

    /** Log an info exception and a message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun i(t: Throwable, noinline message: () -> String) = Timber.i(t, "%s", LazyString(message))

    /** Log a warning message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun w(noinline message: () -> String) = Timber.w("%s", LazyString(message))

    /** Log a warning exception and a message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun w(t: Throwable, noinline message: () -> String) = Timber.w(t, "%s", LazyString(message))

    /** Log an error message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun e(noinline message: () -> String) = Timber.e("%s", LazyString(message))

    /** Log an error exception and a message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun e(t: Throwable, noinline message: () -> String) = Timber.e(t, "%s", LazyString(message))

    /** Log an assert message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun wtf(noinline message: () -> String) = Timber.wtf("%s", LazyString(message))

    /** Log an assert exception and a message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun wtf(t: Throwable, noinline message: () -> String) = Timber.wtf(t, "%s", LazyString(message))

    // These functions forward just to the real timber. They aren't necessary, but they allow method
    // chaining like the normal Timber interface.

    /** A view into Timber's planted trees as a tree itself. */
    @JvmStatic
    fun asTree(): Timber.Tree = Timber.asTree()

    /** Add a new logging tree. */
    @JvmStatic
    fun plant(tree: Timber.Tree) = Timber.plant(tree)

    /** Set a one-time tag for use on the next logging call. */
    @JvmStatic
    fun tag(tag: String): Timber.Tree = Timber.tag(tag)

    /** A view into Timber's planted trees as a tree itself. */
    @JvmStatic
    fun uproot(tree: Timber.Tree) = Timber.uproot(tree)

    /** Set a one-time tag for use on the next logging call. */
    @JvmStatic
    fun uprootAll() = Timber.uprootAll()
}

class LazyString(val initializer: () -> String) {
    val string: String by lazy(initializer)
    override fun toString() = string
}
