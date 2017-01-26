package com.github.ajalt.timberkt

import timber.log.Timber

//
// Static methods on the Timber object
//

object Timber {
    /** Log a verbose message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun v(message: () -> String) = log { Timber.v(message()) }

    /** Log a verbose exception and a message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun v(t: Throwable, message: () -> String) = log { Timber.v(t, message()) }

    /** Log a debug message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun d(message: () -> String) = log { Timber.d(message()) }

    /** Log a debug exception and a message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun d(t: Throwable, message: () -> String) = log { Timber.d(t, message()) }

    /** Log an info message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun i(message: () -> String) = log { Timber.i(message()) }

    /** Log an info exception and a message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun i(t: Throwable, message: () -> String) = log { Timber.i(t, message()) }

    /** Log a warning message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun w(message: () -> String) = log { Timber.w(message()) }

    /** Log a warning exception and a message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun w(t: Throwable, message: () -> String) = log { Timber.w(t, message()) }

    /** Log an error message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun e(message: () -> String) = log { Timber.e(message()) }

    /** Log an error exception and a message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun e(t: Throwable, message: () -> String) = log { Timber.e(t, message()) }

    /** Log an assert message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun wtf(message: () -> String) = log { Timber.wtf(message()) }

    /** Log an assert exception and a message that will be evaluated lazily when the message is printed */
    @JvmStatic
    inline fun wtf(t: Throwable, message: () -> String) = log { Timber.wtf(t, message()) }

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

//
// Extensions on trees
//

/** Log a verbose message that will be evaluated lazily when the message is printed */
inline fun Timber.Tree.v(message: () -> String) = log { v(message()) }

/** Log a verbose exception and a message that will be evaluated lazily when the message is printed */
inline fun Timber.Tree.v(t: Throwable, message: () -> String) = log { v(t, message()) }

/** Log a debug message that will be evaluated lazily when the message is printed */
inline fun Timber.Tree.d(message: () -> String) = log { d(message()) }

/** Log a debug exception and a message that will be evaluated lazily when the message is printed */
inline fun Timber.Tree.d(t: Throwable, message: () -> String) = log { d(t, message()) }

/** Log an info message that will be evaluated lazily when the message is printed */
inline fun Timber.Tree.i(message: () -> String) = log { i(message()) }

/** Log an info exception and a message that will be evaluated lazily when the message is printed */
inline fun Timber.Tree.i(t: Throwable, message: () -> String) = log { i(t, message()) }

/** Log a warning message that will be evaluated lazily when the message is printed */
inline fun Timber.Tree.w(message: () -> String) = log { w(message()) }

/** Log a warning exception and a message that will be evaluated lazily when the message is printed */
inline fun Timber.Tree.w(t: Throwable, message: () -> String) = log { w(t, message()) }

/** Log an error message that will be evaluated lazily when the message is printed */
inline fun Timber.Tree.e(message: () -> String) = log { e(message()) }

/** Log an error exception and a message that will be evaluated lazily when the message is printed */
inline fun Timber.Tree.e(t: Throwable, message: () -> String) = log { e(t, message()) }

/** Log an assert message that will be evaluated lazily when the message is printed */
inline fun Timber.Tree.wtf(message: () -> String) = log { wtf(message()) }

/** Log an assert exception and a message that will be evaluated lazily when the message is printed */
inline fun Timber.Tree.wtf(t: Throwable, message: () -> String) = log { wtf(t, message()) }

//
// Plain functions
//

/** Log a verbose message that will be evaluated lazily when the message is printed */
inline fun v(message: () -> String) = log { Timber.v(message()) }

/** Log a verbose exception and a message that will be evaluated lazily when the message is printed */
inline fun v(t: Throwable, message: () -> String) = log { Timber.v(t, message()) }

/** Log a debug message that will be evaluated lazily when the message is printed */
inline fun d(message: () -> String) = log { Timber.d(message()) }

/** Log a debug exception and a message that will be evaluated lazily when the message is printed */
inline fun d(t: Throwable, message: () -> String) = log { Timber.d(t, message()) }

/** Log an info message that will be evaluated lazily when the message is printed */
inline fun i(message: () -> String) = log { Timber.i(message()) }

/** Log an info exception and a message that will be evaluated lazily when the message is printed */
inline fun i(t: Throwable, message: () -> String) = log { Timber.i(t, message()) }

/** Log a warning message that will be evaluated lazily when the message is printed */
inline fun w(message: () -> String) = log { Timber.w(message()) }

/** Log a warning exception and a message that will be evaluated lazily when the message is printed */
inline fun w(t: Throwable, message: () -> String) = log { Timber.w(t, message()) }

/** Log an error message that will be evaluated lazily when the message is printed */
inline fun e(message: () -> String) = log { Timber.e(message()) }

/** Log an error exception and a message that will be evaluated lazily when the message is printed */
inline fun e(t: Throwable, message: () -> String) = log { Timber.e(t, message()) }

/** Log an assert message that will be evaluated lazily when the message is printed */
inline fun wtf(message: () -> String) = log { Timber.wtf(message()) }

/** Log an assert exception and a message that will be evaluated lazily when the message is printed */
inline fun wtf(t: Throwable, message: () -> String) = log { Timber.wtf(t, message()) }

/** @suppress */
inline fun log(block: () -> Unit) {
    if (Timber.treeCount() > 0) block()
}
