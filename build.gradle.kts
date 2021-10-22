import org.jetbrains.compose.compose

// Add compose gradle plugin
plugins {
    kotlin("multiplatform") version "1.5.30"
    id("org.jetbrains.compose") version ("1.0.0-alpha4-build331")
}
group = "io.github.ch8n"
version = "1.0.0-alpha01"

// Add maven repositories
repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {

}

kotlin {
    js(IR) {
        browser()
        binaries.executable()
    }
    sourceSets {
        val jsMain by getting {
            kotlin.srcDir("src/jsMain/kotlin")
            resources.srcDir("src/jsMain/resources")
            dependencies {
                implementation(compose.web.core)
                implementation(compose.runtime)
            }
        }
    }
}