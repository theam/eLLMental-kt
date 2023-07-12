group = "com.theagilemonkeys.llmental.core"

val http4kVersion: String by project
val logbackVersion: String by project

plugins {
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.serialization") version "1.8.22"
}

dependencies {
    implementation(platform("org.http4k:http4k-bom:$http4kVersion"))
    implementation("org.http4k:http4k-core")
    implementation("org.http4k:http4k-client-okhttp")
    implementation("org.http4k:http4k-server-ktorcio")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
}
