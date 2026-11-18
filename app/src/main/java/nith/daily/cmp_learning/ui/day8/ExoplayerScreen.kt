package nith.daily.cmp_learning.ui.day8

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.retain.RetainedEffect
import androidx.compose.runtime.retain.retain
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.compose.ContentFrame
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun ExoplayerScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var isPlaying by retain {
        mutableStateOf(false)
    }
    var currentPosition by retain {
        mutableLongStateOf(0L)
    }
    var duration by retain {
        mutableLongStateOf(0L)
    }
    var isSeeking by retain {
        mutableStateOf(false)
    }
    var isBuffering by retain {
        mutableStateOf(false)
    }
    var isPlayerUiVisible by retain {
        mutableStateOf(false)
    }
    val player = retain {
        ExoPlayer.Builder(context.applicationContext)
            .build()
    }

    RetainedEffect(player) {
        val listener = object : Player.Listener {
            override fun onIsPlayingChanged(playing: Boolean) {
                super.onIsPlayingChanged(playing)
                isPlaying = playing
            }

            override fun onPlaybackStateChanged(playbackState: Int) {
                super.onPlaybackStateChanged(playbackState)
                isBuffering = playbackState == Player.STATE_BUFFERING
                if(playbackState == Player.STATE_READY) {
                    duration = player.duration.coerceAtLeast(0)
                }
            }
        }
        player.addListener(listener)

        onRetire {
            player.removeListener(listener)
            player.release()
        }
    }
    val videoPickerLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.PickVisualMedia()) { uri ->
            uri?.let {
                player.setMediaItem(MediaItem.fromUri(it))
            }
            player.prepare()
            player.play()
        }

    LaunchedEffect(isPlayerUiVisible, isSeeking, isPlaying) {
        delay(5000L.milliseconds)
        if(!isSeeking) {
            isPlayerUiVisible = false
        }
    }

    LaunchedEffect(player, isPlaying, isSeeking) {
        while(isPlaying) {
            if(!isSeeking) {
                currentPosition = player.currentPosition.coerceAtLeast(0)
            }
            delay(16L.milliseconds)
        }
    }
    Column(
        modifier = modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterVertically)
    ) {
        Button(onClick = {
            videoPickerLauncher.launch(
                PickVisualMediaRequest(
                    mediaType = ActivityResultContracts.PickVisualMedia.VideoOnly
                )
            )
        }) {
            Text(text = "Pick video")
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            ContentFrame(
                player = player,
                modifier = Modifier.fillMaxWidth()
                    .clickable(
                    interactionSource = null,
                    indication = null
                ) {
                    isPlayerUiVisible = !isPlayerUiVisible
                }
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                AnimatedVisibility(
                    visible = isPlayerUiVisible,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    PlayerUi(
                        isPlaying = isPlaying,
                        isBuffering = isBuffering,
                        isSeeking = isSeeking,
                        currentPosition = currentPosition,
                        duration = duration,
                        onSeekBarPositionChange = {
                            isSeeking = true
                            currentPosition = it
                        },
                        onSeekBarPositionChangeFinished = {
                            player.seekTo(it)
                            isSeeking = false
                        },
                        onPlayPauseClick = {
                            when {
                                !isPlaying && player.playbackState == Player.STATE_ENDED -> {
                                    player.seekTo(0)
                                    player.play()
                                }
                                !isPlaying -> player.play()
                                isPlaying -> player.pause()
                            }
                        }
                    )
                }
            }
        }
    }
}