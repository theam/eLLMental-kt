val kotlinVersion: String by project
val kotestVersion: String by project
val kspVersion: String by project
val arrowVersion: String by project
val arrowMetaVersion: String by project
val arrowAnalysisVersion: String by project


plugins {
    application
    kotlin("multiplatform") version "1.8.20" apply true
    id("io.kotest.multiplatform") version "5.5.4" apply true
    id("com.google.devtools.ksp") version "1.8.20-1.0.11" apply true
//    id("io.arrow-kt.analysis.kotlin") version "2.0.2" apply true
}

application {
    mainClass.set("com.theagilemonkeys.llmental.core.MainKt")
}

kotlin {
    jvm() {
        withJava()
    }

    js(IR) {
//        browser()
        nodejs()
    }

    linuxX64()

    mingwX64()

    macosArm64()

    sourceSets {
        commonMain {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation("io.arrow-kt:arrow-core:$arrowVersion")
                implementation("io.arrow-kt:arrow-fx-coroutines:$arrowVersion")
                implementation("io.arrow-kt:arrow-optics:$arrowVersion")
            }
        }
        commonTest {
            dependencies {
                implementation("io.kotest:kotest-property:$kotestVersion")
                implementation("io.kotest:kotest-framework-engine:$kotestVersion")
                implementation("io.kotest:kotest-assertions-core:$kotestVersion")
            }
        }
    }
}

dependencies {
    val opticsPlugin = "io.arrow-kt:arrow-optics-ksp-plugin:$arrowVersion"
    add("kspCommonMainMetadata", opticsPlugin)
    add("kspJvm", opticsPlugin)
    add("kspJvmTest", opticsPlugin)
    add("kspJs", opticsPlugin)
    add("kspJsTest", opticsPlugin)
//    add("kspAndroidNativeX64", opticsPlugin)
//    add("kspAndroidNativeX64Test", opticsPlugin)
//    add("kspAndroidNativeArm64", opticsPlugin)
//    add("kspAndroidNativeArm64Test", opticsPlugin)
//    add("kspLinuxX64", opticsPlugin)
//    add("kspLinuxX64Test", opticsPlugin)
    add("kspMingwX64", opticsPlugin)
    add("kspMingwX64Test", opticsPlugin)
}
