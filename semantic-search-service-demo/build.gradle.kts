import com.google.cloud.tools.gradle.appengine.appyaml.AppEngineAppYamlExtension

val ktor_version: String by project
val kotlin_version: String by project
val gce_logback_version: String by project

plugins {
    application
    // Required for fat JAR deployment
    id("io.ktor.plugin") version "2.3.2" 
    // Required for GCP app engine deployment
    // id("com.github.johnrengelman.shadow") version "7.1.2" 
    id("com.google.cloud.tools.appengine") version "2.4.5"
}

application {
    mainClass.set("com.theagilemonkeys.semanticSearchServiceDemo.MainKt")
}

dependencies {
    implementation(projects.llmentalCore)
    implementation(projects.modules.embeddingsModel)
    implementation(projects.modules.vectorStore)
    implementation(projects.modules.semanticSearch)
}



configure<AppEngineAppYamlExtension> {
    stage {
        setArtifact("build/libs/${project.name}-all.jar")
    }
    deploy {
        version = "GCLOUD_CONFIG"
        projectId = "GCLOUD_CONFIG"
    }
}
