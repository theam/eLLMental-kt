enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "ellmental"
include(
    "core",
    "modules:embeddingsmodel",
    "modules:vectorstore",
    "modules:semanticsearch",
    "examples:semanticsearchservicedemo"
)

// Required for app engine deployment
pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("com.google.cloud.tools.appengine")) {
                useModule("com.google.cloud.tools:appengine-gradle-plugin:${requested.version}")
            }
        }
    }
}
