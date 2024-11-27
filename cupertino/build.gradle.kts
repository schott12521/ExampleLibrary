@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("multiplatform-module-convention")
    alias(libs.plugins.serialization)
    alias(libs.plugins.composeJB)
    alias(libs.plugins.compose.compiler)
    id("publishing-convention")
}

kotlin {

    sourceSets {
        commonMain.dependencies {
            api(projects.cupertinoCore)
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.uiUtil)
            implementation(libs.datetime)
            implementation(libs.atomicfu)
            implementation(libs.serialization)
        }
    }
}
