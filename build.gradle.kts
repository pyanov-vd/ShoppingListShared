plugins {
    val kotlinVersion = "1.6.21"
    kotlin("multiplatform") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
    id("com.android.library") version "7.2.0"
}

group = "com.globus.shoppinglist"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
}

val shareTargetSdk = 32
val shareMinSdk = 24

kotlin {
    android("androidPD")

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "ShoppingListShared"
        }
    }

    sourceSets {
    //SHARED
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    //ANDROID
        val androidPDMain by getting {
            dependencies {
                rootProject
                implementation("com.google.android.material:material:1.6.0")
            }
        }
        val androidPDTest by getting {
            dependencies {
                implementation("junit:junit:4.13.2")
            }
        }

    //IOS
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosPDMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
            }
        }

        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosPDTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = shareTargetSdk
    sourceSets["main"].manifest.srcFile("src/androidPDMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = shareMinSdk
        targetSdk = shareTargetSdk
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}