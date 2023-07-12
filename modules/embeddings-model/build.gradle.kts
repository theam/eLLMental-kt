group = "com.theagilemonkeys.llmental.embeddings-model"

val ktorVersion: String by project

plugins {
    kotlin("jvm") version "1.8.22"
    id("com.google.devtools.ksp") version "1.8.22-1.0.11"
}

dependencies {
    implementation(projects.llmentalCore)
    implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
}
