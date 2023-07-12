group = "com.theagilemonkeys.ellmental.semanticsearchservicedemo"

val http4kVersion: String by project

plugins {
    application
    kotlin("plugin.serialization") version "1.8.22"
}

application {
    mainClass.set("com.theagilemonkeys.semanticsearchservicedemo.MainKt")
}

dependencies {
    implementation(projects.core)
    implementation(projects.modules.embeddingsmodel)
    implementation(projects.modules.vectorstore)
    implementation(projects.modules.semanticsearch)
    implementation(platform("org.http4k:http4k-bom:$http4kVersion"))
    implementation("org.http4k:http4k-core")
}
