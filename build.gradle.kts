plugins {
    // trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.composeCompiler).apply(false)
    alias(libs.plugins.jetbrainsCompose).apply(false)
    alias(libs.plugins.kotlinCocoapods) apply false
    alias(libs.plugins.kotlinxSerialization) apply false
    alias(libs.plugins.ktlint) apply true
}

// In root build.gradle.kts
subprojects {
    if (name == "shared") {
        apply(plugin = "org.jlleitschuh.gradle.ktlint")
    }
}

ktlint {
    android.set(true)
    enableExperimentalRules.set(true)
    outputToConsole.set(true)
    verbose.set(true)
    ignoreFailures = true
    filter {
        // Exclude the build and generated directories
        exclude("**/build/**")
        exclude("**/generated/**")
    }
}
