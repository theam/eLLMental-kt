group = "com.theagilemonkeys.ellmental.modules.semanticsearch"

plugins {
    kotlin("jvm") version "1.8.22"
    id("com.google.devtools.ksp") version "1.8.22-1.0.11"
    kotlin("plugin.serialization") version "1.8.22"
}

dependencies {
    implementation(projects.core)
    implementation(projects.modules.embeddingsmodel)
    implementation(projects.modules.vectorstore)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8")
}
