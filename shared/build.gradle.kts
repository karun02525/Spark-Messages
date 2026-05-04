import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework
import com.vanniktech.maven.publish.KotlinMultiplatform
import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("org.jetbrains.compose")
    kotlin("plugin.compose")
    id("com.vanniktech.maven.publish") version "0.29.0"
}

// 1. Set global coordinates
group = "io.github.karun02525"
version = "1.0.5"

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    // 2. Configure XCFramework for iOS distribution
    val xcf = XCFramework("Shared")
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
            xcf.add(this)
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation("io.insert-koin:koin-android:4.2.1")
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)

            implementation("io.insert-koin:koin-core:4.2.1")
            // API ensures consuming apps see Coroutine classes
            api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
        }
    }
}

android {
    namespace = "com.prikaro.spark.shared"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

mavenPublishing {
    // 1. Configure KMP targets
    configure(KotlinMultiplatform(
        javadocJar = JavadocJar.Empty(),
        androidVariantsToPublish = listOf("release")
    ))

    // 2. Artifact Identity
    coordinates(
        groupId = group.toString(),
        artifactId = "spark-shared",
        version = version.toString()
    )

    // 3. POM Metadata (Required by Maven Central)
    pom {
        name.set("Spark Shared Library")
        description.set("Shared KMP library with Compose UI components")
        url.set("https://github.com/karun02525/Spark-Messages")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("prikaro")
                name.set("Prikaro")
                email.set("karunkumar02525@gmail.com") // Recommended
            }
        }
        scm {
            connection.set("scm:git:github.com/karun02525/Spark-Messages.git")
            developerConnection.set("scm:git:ssh://github.com/karun02525/Spark-Messages.git")
            url.set("https://github.com/karun02525/Spark-Messages")
        }
    }

    // 4. Sign all publications (Required for Cloud)
    signAllPublications()
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
}