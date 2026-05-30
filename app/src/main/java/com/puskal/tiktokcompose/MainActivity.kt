package com.nigergram.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created in Zetra Lab on 05/30/2026.
 * Developed by Zetra Company.
 */

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            RootScreen()
        }
    }
}

private object Destinations {
    const val Home = "HOME"
    const val Feed = "FEED"
    const val Sheet = "SHEET"
}
