import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val rootGroupId = "com.theagilemonkeys.ellmental"

val kotlinVersion: String by project
val kotlinxSerializationVersion: String by project
val kotestVersion: String by project
val arrowVersion: String by project
val arrowMetaVersion: String by project
val kotlinOpenaiVersion: String by project
val dotenvKotlinVersion: String by project

plugins {
    kotlin("jvm") version "1.8.22"
    id("com.google.devtools.ksp") version "1.8.22-1.0.11"
    id("maven-publish")
    id("org.jetbrains.dokka") version "1.8.20"
}

repositories {
    mavenCentral()
}

subprojects {
    group = rootGroupId
    version = rootProject.version.toString()

    apply(plugin = "kotlin")
    apply(plugin = "com.google.devtools.ksp")
    apply(plugin = "maven-publish")
    apply(plugin = "org.jetbrains.dokka")

    repositories {
        mavenCentral()
    }

    configure<PublishingExtension> {
        publications {
            create<MavenPublication>("mavenJava") {
                from(components["java"])
            }
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
        kotlinOptions.freeCompilerArgs = listOf("-Xcontext-receivers")
    }

    dependencies {
        "ksp"("io.arrow-kt:arrow-optics-ksp-plugin:$arrowVersion")
        "implementation"(kotlin("stdlib"))
        "implementation"(kotlin("reflect"))
        "implementation"("io.github.cdimascio:dotenv-kotlin:$dotenvKotlinVersion")
        "implementation"("com.aallam.openai:openai-client:$kotlinOpenaiVersion")
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

tasks.register<DefaultTask>("processDokkaDocs") {
    dependsOn("dokkaGfmCollector")

    doLast {
        val sourceDir = file("build/dokka/gfmCollector")
        val targetDir = file("website/docs/api_docs")

        fun String.convertDashedToUpper(): String {
//            return this.split("-").joinToString("") {
//                if (it.isNotEmpty() && indexOf(it) != 0) it.capitalize()
//                else ""
//            }
            var shouldCapitalize = false
            return this.map {
                when {
                    it == '-' -> {
                        shouldCapitalize = true
                        ""
                    }

                    shouldCapitalize -> {
                        shouldCapitalize = false
                        it.toUpperCase()
                    }

                    else -> it
                }
            }.joinToString("")
        }

        delete(targetDir)

        copy {
            from(sourceDir)
            into(targetDir)
        }

        fileTree(targetDir).forEach { file ->
            if (file.isFile) {
                val content = file
                    .readText()
                    .replace("<br>", "<br/>")
                    .replace("[jvm]\\", "")

                val tag = when {
                    content.contains("Package") -> ""
                    content.contains("interface") -> "interface"
                    content.contains("constructor") -> "class"
                    content.contains("fun ") -> "fun"
                    content.contains("val ") -> "val"
                    else -> ""
                }

                val parentName = file.parentFile.name.replace(rootGroupId, "").convertDashedToUpper()
                val fileName = file.nameWithoutExtension.convertDashedToUpper()
                val label = when (fileName) {
                    parentName -> parentName
                    "index" -> parentName
                    else -> fileName
                }

                val contentWithFrontMatter = """---
title: $fileName
sidebar_label: "$tag $label"
sidebar_class_name: "codetag-sidebar"
sidebar_custom_props:
  tag: $tag
  name: $label
---

$content""".trimIndent()

                file.writeText(contentWithFrontMatter)
            }
        }
    }
}
