# Kotlin extensions for Timber

Jake Wharton's [Timber](https://github.com/JakeWharton/timber) library is great. It's a Java library with an API that works well for Java, but that isn't as idiomatic when used in Kotlin. 

This library builds on Timber with an API that's easier to use from Kotlin. Instead of using formatting parameters, you pass a lambda that is only evaluated if the message is logged.

## Usage

1. Configure any `Tree` instances in your Application's `onCreate`, the same way as with plain [Timber](https://github.com/JakeWharton/timber#usage).
2. Call the extension functions from anywhere in your code.

```kotlin
// Standard timber
Timber.d("%d %s", intVar + 3, stringFun())

// Kotlin extensions
Timber.d { "${intVar + 3} ${stringFun()}" }
// or
d { "${intVar + 3} ${stringFun()}" }
```

The same message and tags will be logged in all three cases. 

The Kotlin extensions have the advantage of being more convenient to write, and are also more performant in some circumstances. The passed block is only evaluated if the message is logged, and even if the message is logged to multiple trees, the block is only evaluated once.

Logging exception objects works the same way:

```kotlin
// Standard timber
Timber.e(exception, "%d exceptions", errorCount)

// Kotlin extensions
Timber.e(exception) { "$errorCount exceptions" }
// or
e(exception) { "$errorCount exceptions" }
```

## What about Timber's custom lint checks?

Timber comes with half a dozen lint checks that help you spot incorrect usage of the log calls. 

With the exception of long custom tags, none of the errors those checks look for are possible with this library. You can perform arbitrary code inside of the lambdas passed to the log extensions, and there's no risk of performance problems in your release code since the blocks won't be evaluated unless the messages are printed.

## Download

The Kotlin extensions for Timber are distributed with [JitPack](https://jitpack.io/).

```groovy
repositories {
    maven { url "https://jitpack.io" }
}

compile 'com.github.ajalt:timberkt:1.1.0'
```

## License

```
Copyright 2016 AJ Alt

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```