val kotlinVersion: String by project
val kotestVersion: String by project
val kspVersion: String by project
val arrowVersion: String by project
val arrowMetaVersion: String by project
val arrowAnalysisVersion: String by project

plugins {
    kotlin("multiplatform") version "1.8.20" apply false
}

allprojects {
    group = "com.theagilemonkeys.llmental"
    version = "0.0.1"

    repositories {
        mavenCentral()
    }

    buildscript {
        repositories {
            mavenCentral()
        }
    }

}
