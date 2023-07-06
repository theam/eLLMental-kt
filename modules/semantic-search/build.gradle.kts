plugins {
    kotlin("jvm") version "1.8.22"
    id("com.google.devtools.ksp") version "1.8.22-1.0.11"
    kotlin("plugin.serialization") version "1.8.22"
}

dependencies {
    implementation(projects.llmentalCore)
    implementation(projects.modules.embeddingsModel)
    implementation(projects.modules.vectorStore)
}
