import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.buildKonfig)
}

buildkonfig {
    packageName = "ramzi.eljabali.justjogkmm.shared"

    defaultConfigs {
        val apiKey: String =
            gradleLocalProperties(rootDir, providers).getProperty("QUOTES_API_KEY")

        require(apiKey.isNotEmpty()) { }

        buildConfigField(STRING, "QUOTES_API_KEY", apiKey)
    }
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = false
            freeCompilerArgs += listOf("-Xbinary=bundleId=justjogkmm.shared")
        }
    }

    sourceSets {
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
        }

        commonMain.dependencies {
            // put your multiplatform dependencies here
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.json)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.arrow.core)
            implementation(libs.arrow.fx.coroutines)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "ramzi.eljabali.justjogkmm"
    compileSdk = 35
    defaultConfig {
        minSdk = 28
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

ktlint {
    android.set(true)
    verbose.set(true)
    ignoreFailures.set(true)
    filter {
        include("src/**/*.kt")
        exclude {
            it.file.path.contains("build/generated")
        }
        exclude {
            it.file.path.contains("commonResClass")
        }
        exclude {
            it.file.path.contains("commonMainResourceAccessors")
        }
    }
}
