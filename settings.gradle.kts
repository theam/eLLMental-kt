enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "llmental"
include(
    "llmental-core",
    "modules:embeddings-model",
    "modules:vector-store",
    "modules:semantic-search",
    "semantic-search-service-demo"
)
