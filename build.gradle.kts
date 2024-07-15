plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.serialization") version "2.0.0"
}

group = "io.smfdrummer"
version = "1.0"

repositories {
    maven {
        setUrl("https://maven.aliyun.com/repository/public/")
        setUrl("https://maven.aliyun.com/repository/central")
    }
    mavenLocal()
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.1")
    implementation("org.noear:snack3:3.2.104")
}

tasks.test {
    useJUnitPlatform()
}