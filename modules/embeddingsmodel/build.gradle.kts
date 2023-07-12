group = "com.theagilemonkeys.ellmental.modules.embeddingsmodel"

val ktorVersion: String by project

plugins {
    kotlin("jvm") version "1.8.22"
    id("com.google.devtools.ksp") version "1.8.22-1.0.11"
}

dependencies {
    implementation(projects.core)
    implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
}
