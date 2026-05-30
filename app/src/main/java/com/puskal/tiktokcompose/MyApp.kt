package com.nigergram.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created in Zetra Lab on 05/30/2026.
 * Developed by Zetra Company.
 */

@HiltAndroidApp
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
