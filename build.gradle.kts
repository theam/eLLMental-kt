import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion: String by project
val kotestVersion: String by project
val arrowVersion: String by project
val arrowMetaVersion: String by project
val arrowAnalysisVersion: String by project

plugins {
    kotlin("jvm") version "1.6.0"
    id("com.google.devtools.ksp") version "1.6.0-1.0.2"
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("io.arrow-kt.analysis.kotlin:io.arrow-kt.analysis.kotlin.gradle.plugin:2.0-RC3")
    }
}

allprojects {
    group = "com.theagilemonkeys.llmental"
    version = "0.0.1"

    repositories {
        mavenCentral()
    }

    apply(plugin = "kotlin")
    apply(plugin = "io.arrow-kt.analysis.kotlin")
    apply(plugin = "com.google.devtools.ksp")

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    dependencies {
        "ksp"("io.arrow-kt:arrow-optics-ksp-plugin:$arrowVersion")
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
