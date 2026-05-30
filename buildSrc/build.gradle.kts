plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("AndroidCoreLibraryPlugin") {
            id = "android.core.library.plugin"
            // Ensure this class name and package exist exactly as written
            implementationClass = "plugin.AndroidCoreLibraryPlugin" 
        }
    }
}
