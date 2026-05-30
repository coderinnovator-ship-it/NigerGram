package plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import com.android.build.gradle.LibraryExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
// Import your specific dependency functions
import baseDependencies
import composeDependencies
import testDependencies

class AndroidCoreLibraryPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            plugins.apply("com.android.library")
            plugins.apply("org.jetbrains.kotlin.android")
            plugins.apply("org.jetbrains.kotlin.plugin.parcelize")
            plugins.apply("com.google.dagger.hilt.android")
            plugins.apply("kotlin-kapt")

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

            dependencies {
                baseDependencies()
                composeDependencies()
                testDependencies()
            }
        }
    }
}
