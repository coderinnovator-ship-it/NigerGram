plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

gradlePlugin {
    plugins {
        register("AndroidCoreLibraryPlugin") {
            id = "android.core.library.plugin"
            implementationClass = "plugin.AndroidCoreLibraryPlugin"
        }
    }
}

dependencies {
    implementation("com.android.tools.build:gradle:7.2.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10")
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.44.2")
}

// Clean structure enforcement
tasks.withType<org.gradle.jvm.tasks.Jar> {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
