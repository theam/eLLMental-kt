enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "ellmental"
include(
    "core",
    "modules:embeddingsmodel",
    "modules:vectorstore",
    "modules:semanticsearch",
    "examples:semanticsearchservicedemo"
)
