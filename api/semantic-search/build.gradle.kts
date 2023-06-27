plugins {
    application
}

application {
    mainClass.set("com.theagilemonkeys.llmental.api.SemanticSearch")
    version = "${project.version}"
}

dependencies {
    val ktorVersion: String by project
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-serialization-jackson:$ktorVersion")
    implementation("io.ktor:ktor-server-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-server-status-pages:$ktorVersion")
    implementation(project(":services:semantic-search"))
}
