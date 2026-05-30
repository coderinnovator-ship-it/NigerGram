package plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import com.android.build.gradle.LibraryExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidCoreLibraryPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            // Apply the necessary plugins
            plugins.apply("com.android.library")
            plugins.apply("org.jetbrains.kotlin.android")
            plugins.apply("org.jetbrains.kotlin.plugin.parcelize")
            plugins.apply("com.google.dagger.hilt.android")
            plugins.apply("kotlin-kapt")

            // Configure Android settings
            configure<LibraryExtension> {
                compileSdk = AppConfig.compileSdk
                defaultConfig {
                    minSdk = AppConfig.minSdk
                    targetSdk = AppConfig.targetSdk
                    consumerProguardFiles("consumer-rules.pro")
                }
                
                compileOptions {
                    sourceCompatibility = org.gradle.api.JavaVersion.VERSION_1_8
                    targetCompatibility = org.gradle.api.JavaVersion.VERSION_1_8
                }

                buildFeatures {
                    compose = true
                }
            }

            // Apply dependencies
            dependencies {
                baseDependencies()
                composeDependencies()
                testDependencies()
            }
        }
    }
}
