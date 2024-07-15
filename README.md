### 这是什么库？
这是一个基于 [kotlinx.serialization-json](https://github.com/Kotlin/kotlinx.serialization) 的扩展库，由于本人想从 [fastjson2](https://github.com/alibaba/fastjson2) 转到 kotlin 官方的序列化库来解析 json 数据，但苦于 kotlin 官方的序列化库并没有丰富的函数实现，调用复杂且单一，所以我一气之下写了这么个扩展函数库。

### 使用这个库都需要什么？
+ 首先，你需要引入
```Kotlin DSL
plugins {
    kotlin("jvm") version "2.0.0" // or kotlin("multiplatform") or any other kotlin plugin
    kotlin("plugin.serialization") version "2.0.0"
}
```
与
```Kotlin DSL
repositories {
    maven {
        setUrl("https://maven.aliyun.com/repository/public/")
        setUrl("https://maven.aliyun.com/repository/central")
    }
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${latestVersion}")
    implementation("org.noear:snack3:${latestVersion}")
}
```
+ 其次，还需要一个聪明的头脑、一双积极发现bug的眼睛以及一份热情提交issue的爱心

### 照你这么说，这个项目还不成熟？
这个库是我一气之下写出来的纯扩展库，没有加什么花里胡哨的东西，同样的也没有考虑到一些完全可避免的不必要的内存开销。所以，我希望大家在使用这个库时多多批评，向我提交任何可添加、优化本库代码的issue，让这个库更加完备可用。

### 不是，哥们，你能不能把库放到 jitpack 上让我们引用更舒服一点？
由于项目引用了两个库，一个是官方的序列化库，另一个是号称最快 JsonPath 解析的 [snack3](https://gitee.com/noear/snack3/) ，所以目前没有将这个库用作快捷引用的打算，大家使用直接把 [main/kotlin](https://github.com/SMFDrummer/FastKsJson/tree/master/src/main/kotlin) 下面的文件下载放到你自己的项目文件夹中即可。