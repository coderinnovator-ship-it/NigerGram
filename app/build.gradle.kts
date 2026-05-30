plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "com.nigergram.app"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.nigergram.app"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.VersionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = AppConfig.KotlinCompilerExtension
    }

    packagingOptions {
        resources.excludes.add("META-INF/**/*")
    }
}

dependencies {
    // Keep custom helper setup tracks intact
    baseDependencies()
    composeDependencies()
    testDependencies()
    moduleDependencies()

    // Explicitly link the local rebranded infrastructure modules to avoid project dependency resolution failures
    implementation(project(":core"))
    implementation(project(":common:theme"))
    implementation(project(":common:composable"))
    implementation(project(":domain"))
    implementation(project(":data"))
    
    // Explicitly link all core features
    implementation(project(":feature:home"))
    implementation(project(":feature:commentlisting"))
    implementation(project(":feature:creatorprofile"))
    implementation(project(":feature:inbox"))
    implementation(project(":feature:authentication"))
    implementation(project(":feature:loginwithemailphone"))
    implementation(project(":feature:friends"))
    implementation(project(":feature:myprofile"))
    implementation(project(":feature:setting"))
    implementation(project(":feature:cameramedia"))
}
