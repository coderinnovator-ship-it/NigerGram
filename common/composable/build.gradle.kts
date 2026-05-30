plugins {
    id("plugin.android-common")
}

dependencies {
    // These link the bridge to your other modules
    implementation(project(":common:theme"))
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":core"))

    media3Dependency()
}
