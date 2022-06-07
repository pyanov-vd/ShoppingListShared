plugins {
    val kotlinVersion: String by System.getProperties()
    kotlin("multiplatform") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
    id("com.android.library") version "7.2.0"
}

group = "com.globus.shoppinglist"
version = "0.0.1"
val shareTargetSdk = 32
val shareMinSdk = 24

//Dependencies versions
val kotlinVersion: String by System.getProperties()
val coroutinesVersion = "1.6.2"
val serializationVersion = "1.3.2"
val kodeinVersion = "7.12.0"
val ktorVersion = "2.0.2"

repositories {
    google()
    mavenCentral()
}

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
        val commonMain by getting {
            dependencies {
                api("org.jetbrains.kotlinx:kotlinx-serialization-core:$serializationVersion")

                //DI - Kodein 7.12.0
                implementation("org.kodein.di:kodein-di:$kodeinVersion")


                // HTTP - Ktor
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-json:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-client-logging:$ktorVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    //ANDROID
        val androidPDMain by getting {
            dependencies {
                rootProject
                api("com.google.android.material:material:1.6.0")
                // HTTP - Ktor
                api("io.ktor:ktor-client-okhttp:$ktorVersion")

                //Coroutines
                //implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
                //implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
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
                // HTTP - Ktor
                implementation("io.ktor:ktor-client-darwin:$ktorVersion")
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