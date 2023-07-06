plugins {
    application
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
