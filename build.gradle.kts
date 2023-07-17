val rootGroupId = "com.theagilemonkeys.ellmental"

buildscript {
    repositories {
        mavenCentral()
    }
}

repositories {
    mavenCentral()
}

//val kotlinVersion: String by project
//val kotlinxSerializationVersion: String by project
//val kotestVersion: String by project
//val arrowVersion: String by project
//val arrowMetaVersion: String by project
//val kotlinOpenaiVersion: String by project
//val dotenvKotlinVersion: String by project
//
//plugins {
//    kotlin("multiplatform") version "1.8.22"
//    id("com.google.devtools.ksp") version "1.8.22-1.0.11"
//    id("maven-publish")
//}
//
//repositories {
//    mavenCentral()
//}
//
//subprojects {
//    group = rootGroupId
//    version = rootProject.version.toString()
//
//    apply(plugin = "com.google.devtools.ksp")
//    apply(plugin = "maven-publish")
//
//    repositories {
//        mavenCentral()
//    }
//
//    configure<PublishingExtension> {
//        publications {
//            create<MavenPublication>("mavenJava") {
//                from(components["java"])
//            }
//        }
//    }
//
//    tasks.withType<KotlinCompile> {
//        kotlinOptions.jvmTarget = "17"
//        kotlinOptions.freeCompilerArgs = listOf("-Xcontext-receivers")
//    }
//
//    dependencies {
//        "ksp"("io.arrow-kt:arrow-optics-ksp-plugin:$arrowVersion")
//        "implementation"(kotlin("stdlib"))
//        "implementation"(kotlin("reflect"))
//        "implementation"("io.github.cdimascio:dotenv-kotlin:$dotenvKotlinVersion")
//        "implementation"("com.aallam.openai:openai-client:$kotlinOpenaiVersion")
//        "implementation"("org.jetbrains.kotlinx:kotlinx-serialization-core:$kotlinxSerializationVersion")
//        "implementation"("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxSerializationVersion")
//        "testImplementation"("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
//        "testImplementation"("io.kotest:kotest-runner-junit5:$kotestVersion")
//        "testImplementation"("io.kotest:kotest-assertions-core:$kotestVersion")
//        "testImplementation"("io.kotest:kotest-property:$kotestVersion")
//    }
//
//    tasks.withType<Test>().configureEach {
//        useJUnitPlatform()
//    }
//}
