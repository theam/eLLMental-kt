val kotlinVersion: String by project
val kotestVersion: String by project
val arrowVersion: String by project
val arrowMetaVersion: String by project
val arrowAnalysisVersion: String by project

plugins {
    application
    id("com.google.devtools.ksp") version "1.6.0-1.0.2"
    kotlin("jvm") version "1.6.0"
}

group = "com.theagilemonkeys"
version = "0.0.1"

application {
    mainClass.set("org.theagilemonkeys.yolo.MainKt")
}

repositories {
    mavenCentral()
}

buildscript {
    dependencies {
        classpath("io.arrow-kt.analysis.kotlin:io.arrow-kt.analysis.kotlin.gradle.plugin:2.0-RC3")
    }
}

apply(plugin = "io.arrow-kt.analysis.kotlin")

dependencies {
    ksp("io.arrow-kt:arrow-optics-ksp-plugin:$arrowVersion")
    implementation("io.arrow-kt:arrow-core:$arrowVersion")
    implementation("io.arrow-kt:arrow-fx-coroutines:$arrowVersion")
    implementation("io.arrow-kt:arrow-optics:$arrowVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("io.kotest:kotest-property:$kotestVersion")
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}
