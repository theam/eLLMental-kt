import com.google.cloud.tools.gradle.appengine.appyaml.AppEngineAppYamlExtension

val ktor_version: String by project
val kotlin_version: String by project
val gce_logback_version: String by project
val http4kVersion: String by project

group = "com.theagilemonkeys.ellmental.semanticsearchservicedemo"

val http4kVersion: String by project

plugins {
    application
    kotlin("plugin.serialization") version "1.8.22"
    // Required for fat JAR deployment
    id("io.ktor.plugin") version "2.3.2"
    // Required for GCP app engine deployment
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("com.google.cloud.tools.appengine") version "2.4.5"
    // Required for Azure Web App
    id("com.microsoft.azure.azurewebapp") version "1.1.0"
}

application {
    mainClass.set("com.theagilemonkeys.semanticsearchservicedemo.MainKt")
}

version = "all"

azurewebapp {
    resourceGroup = "ellmental-demo-rg"
    appName = "ellmental-demo"
    pricingTier = "F1"
    region = "westus3"

    setRuntime(closureOf<com.microsoft.azure.gradle.configuration.GradleRuntimeConfig> {
        os("Linux")
        webContainer("Java SE")
        javaVersion("Java 17")
    })
    setAppSettings(closureOf<MutableMap<String, String>> {
        put("foo", "bar")
    })
    setAuth(closureOf<com.microsoft.azure.gradle.auth.GradleAuthConfig> {
        type = "azure_cli"
    })
}

tasks.azureWebAppDeploy {
    dependsOn(tasks.shadowJar )
}


configure<AppEngineAppYamlExtension> {
    stage {
        setArtifact("build/libs/${project.name}-${project.version}.jar")
    }
    deploy {
        version = "GCLOUD_CONFIG"
        projectId = "GCLOUD_CONFIG"
    }
}

dependencies {
    implementation(projects.core)
    implementation(projects.modules.embeddingsmodel)
    implementation(projects.modules.vectorstore)
    implementation(projects.modules.semanticsearch)
    implementation(platform("org.http4k:http4k-bom:$http4kVersion"))
    implementation("org.http4k:http4k-core")
}
