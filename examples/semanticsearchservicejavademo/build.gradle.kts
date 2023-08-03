val ktor_version: String by project
val kotlin_version: String by project
val gce_logback_version: String by project
val http4kVersion: String by project

group = "com.theagilemonkeys.ellmental.semanticsearchservicejavademo"

plugins {
    application
    kotlin("plugin.serialization") version "1.8.22"
    // Required for fat JAR deployment
    id("io.ktor.plugin") version "2.3.2"
    // Required for GCP app engine deployment
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}


application {
    mainClass.set("com.theagilemonkeys.ellmental.semanticsearchservicejavademo.SemanticSearchServiceJavaDemo")
}

version = "all"

dependencies {
    implementation(projects.core)
    implementation(projects.modules.embeddingsmodel)
    implementation(projects.modules.vectorstore)
    implementation(projects.modules.semanticsearch)
    implementation("com.google.code.gson:gson:2.8.8")
    compileOnly("com.sparkjava:spark-core:2.9.4")
    compileOnly("org.projectlombok:lombok:1.18.28")
}
