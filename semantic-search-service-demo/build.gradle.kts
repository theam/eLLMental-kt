plugins {
    application
    kotlin("plugin.serialization") version "1.8.22"
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
