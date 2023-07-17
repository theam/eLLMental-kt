enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "ellmental"
include(
    "core",
//    "modules:embeddingsmodel",
//    "modules:vectorstore",
//    "modules:semanticsearch",
//    "examples:semanticsearchservicedemo"
)

pluginManagement {
    plugins {
        id("org.jetbrains.kotlin.multiplatform") version "1.8.22"
    }
}