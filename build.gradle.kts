import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion: String by project
val kotlinxSerializationVersion: String by project
val kotestVersion: String by project
val arrowVersion: String by project
val arrowMetaVersion: String by project

plugins {
    kotlin("jvm") version "1.8.22"
    id("com.google.devtools.ksp") version "1.8.22-1.0.11"
}

repositories {
    mavenCentral()
}

subprojects {
    group = "com.theagilemonkeys.llmental"
    version = "0.0.1"


    repositories {
        mavenCentral()
    }

    apply(plugin = "kotlin")
    apply(plugin = "com.google.devtools.ksp")

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
        kotlinOptions.freeCompilerArgs = listOf("-Xcontext-receivers")
    }

    dependencies {
        "ksp"("io.arrow-kt:arrow-optics-ksp-plugin:$arrowVersion")
        "implementation"(kotlin("stdlib"))
        "implementation"(kotlin("reflect"))
        "implementation"("org.jetbrains.kotlinx:kotlinx-serialization-core:$kotlinxSerializationVersion")
        "implementation"("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxSerializationVersion")
        "implementation"("io.arrow-kt:arrow-core:$arrowVersion")
        "implementation"("io.arrow-kt:arrow-fx-coroutines:$arrowVersion")
        "implementation"("io.arrow-kt:arrow-optics:$arrowVersion")
        "testImplementation"("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
        "testImplementation"("io.kotest:kotest-runner-junit5:$kotestVersion")
        "testImplementation"("io.kotest:kotest-assertions-core:$kotestVersion")
        "testImplementation"("io.kotest:kotest-property:$kotestVersion")
    }

    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
    }
}
