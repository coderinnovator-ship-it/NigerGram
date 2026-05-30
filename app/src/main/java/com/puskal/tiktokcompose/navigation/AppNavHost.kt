package com.nigergram.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.nigergram.authentication.authenticationNavGraph
import com.nigergram.cameramedia.cameraMediaNavGraph
import com.nigergram.commentlisting.commentListingNavGraph
import com.nigergram.core.DestinationRoute.HOME_SCREEN_ROUTE
import com.nigergram.creatorprofile.creatorProfileNavGraph
import com.nigergram.friends.friendsNavGraph
import com.nigergram.home.homeNavGraph
import com.nigergram.inbox.inboxNavGraph
import com.nigergram.loginwithemailphone.loginEmailPhoneNavGraph
import com.nigergram.myprofile.myProfileNavGraph
import com.nigergram.setting.settingNavGraph

/**
 * Created in Zetra Lab on 05/30/2026.
 * Developed by Zetra Company.
 */

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = HOME_SCREEN_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        homeNavGraph(navController)
        commentListingNavGraph(navController)
        creatorProfileNavGraph(navController)
        boxNavGraph(navController)
        authenticationNavGraph(navController)
        loginEmailPhoneNavGraph(navController)
        friendsNavGraph(navController)
        myProfileNavGraph(navController)
        settingNavGraph(navController)
        cameraMediaNavGraph(navController)
    }
}
