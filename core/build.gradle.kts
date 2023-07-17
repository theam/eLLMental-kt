group = "com.theagilemonkeys.ellmental.core"

val http4kVersion: String by project
val logbackVersion: String by project
val kotlinxSerializationVersion: String by project
val coroutinesVersion: String by project

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version "1.8.22"
}

repositories {
    mavenCentral()
}

kotlin {
    jvm()
    js(IR) {
        browser()
        nodejs()
    }
    linuxX64()
    macosX64()
    macosArm64()
    iosSimulatorArm64()
    iosX64()
    mingwX64()


    sourceSets {
        commonMain {
            dependencies {
                implementation(kotlin("stdlib"))
                implementation("org.http4k:http4k-core")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$kotlinxSerializationVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxSerializationVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
                implementation("org.http4k:http4k-client-okhttp")
                implementation("org.http4k:http4k-server-ktorcio")
                implementation("ch.qos.logback:logback-classic:$logbackVersion")
            }
        }


        val jsMain by getting {
            dependencies {
                implementation(kotlin("stdlib-js"))
            }
        }

        val jvmMain by getting
    }
}
