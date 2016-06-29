# Kotlin extensions for Timber

Jake Wharton's [Timber](https://github.com/JakeWharton/timber) library is great. It's a Java library with an API that works well for Java, but that isn't as idiomatic for Kotlin. 

This library builds on Timber with an API that's easier to use from Kotlin. Instead of using formatting parameters, you pass a lambda that is only evaluated if the message is logged.

## Usage

```kotlin
// Standard timber
Timber.d("%d %s", intVar + 3, stringFun())

// Kotlin extensions
Timber.d { "${intVar + 3} ${stringFun()}" }
// or
d { "${intVar + 3} ${stringFun()}" }
```

The same message and tags will be logged in all three cases. 

The Kotlin extensions have the advantage if being more convenient to write, but are also more performant in some circumstances, since the passed block is only evaluated if the message is logged. Even if the message is logged to multiple trees, the block is only evaluated once.

## What about Timber's lint warnings?

Timber comes with half a dozen custom lint checks that help you spot incorrect usage of the log calls. 

All but one of those checks are for problems that are impossible with this library. You can to perform arbitrary code inside of the blocks passed to the log extensions. There's no risk of performance problems in your release code since the blocks won't be evaluated.

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