package com.puskal.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
// Ensure these paths match your folder structure exactly
import com.puskal.core.utils.FileUtils
import com.puskal.core.utils.IntentUtils
import com.puskal.data.model.VideoModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VideoPlayer(
    video: VideoModel,
    pagerState: PagerState,
    pageIndex: Int,
    onSingleTap: (ExoPlayer) -> Unit,
    onDoubleTap: (ExoPlayer, androidx.compose.ui.geometry.Offset) -> Unit,
    onVideoDispose: () -> Unit,
    onVideoGoBackground: () -> Unit
) {
    val context = LocalContext.current
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            repeatMode = Player.REPEAT_MODE_ONE
            playWhenReady = true
        }
    }

    // CHECK THIS LINE: Replace 'videoUrl' with the actual field name from VideoModel.kt
    DisposableEffect(video.videoUrl) { 
        val mediaItem = MediaItem.fromUri(video.videoUrl)
        exoPlayer.setMediaItem(mediaItem)
        exoPlayer.prepare()
        onDispose {
            onVideoDispose()
            exoPlayer.release()
        }
    }
    // ... rest of the code ...
