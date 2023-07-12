group = "com.theagilemonkeys.llmental.vector-store"

val http4kVersion: String by project

plugins {
    kotlin("jvm") version "1.8.22"
    id("com.google.devtools.ksp") version "1.8.22-1.0.11"
    kotlin("plugin.serialization") version "1.8.22"
}

dependencies {
    implementation(projects.llmentalCore)
    implementation(platform("org.http4k:http4k-bom:$http4kVersion"))
    implementation("org.http4k:http4k-core")
    implementation("org.http4k:http4k-client-okhttp")
}
