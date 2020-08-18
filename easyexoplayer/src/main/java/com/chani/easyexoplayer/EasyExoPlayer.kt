package com.chani.easyexoplayer

import android.content.Context
import android.net.Uri
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.audio.AudioAttributes
import com.google.android.exoplayer2.source.ConcatenatingMediaSource
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util

object EasyExoPlayer {
    private lateinit var mediaSources: Array<MediaSource?>
    private var mediaSource: MediaSource? = null
    private var concatenatingMediaSource: ConcatenatingMediaSource? = null
    private var dataSourceFactory: DefaultDataSourceFactory? = null
    private lateinit var listener: Listener
    private lateinit var audioAttributes: AudioAttributes

    private var player: SimpleExoPlayer? = null

    fun initPlayer(context: Context, appName: String) {
        val defaultTrackSelector = DefaultTrackSelector()
        player = ExoPlayerFactory.newSimpleInstance(context, defaultTrackSelector)

        val userAgent = Util.getUserAgent(context, appName)
        dataSourceFactory = DefaultDataSourceFactory(context, userAgent)

        audioAttributes = AudioAttributes.Builder()
            .setUsage(C.USAGE_MEDIA)
            .setContentType(C.CONTENT_TYPE_MOVIE)
            .build()

    }

    fun setPlayListSource(dataSources: List<String>) {
        var index = 0
        mediaSource = null
        mediaSources = arrayOfNulls(dataSources.size)

        dataSources.forEach { _ ->
            val itemMediaSource =
                ExtractorMediaSource.Factory(dataSourceFactory)
                    .createMediaSource(Uri.parse(dataSources[index]))
            mediaSources[index] = itemMediaSource
            index++
        }

        concatenatingMediaSource = ConcatenatingMediaSource(*mediaSources)
    }

    fun setDataSource(dataSources: String) {
        concatenatingMediaSource = null
        val itemMediaSource = ExtractorMediaSource.Factory(dataSourceFactory)
            .createMediaSource(Uri.parse(dataSources))
        mediaSource = itemMediaSource

    }

    fun play() {
        player!!.prepare(
            if (mediaSource == null) concatenatingMediaSource else mediaSource,
            true,
            false
        )
        player!!.playWhenReady = true
    }

    fun rePlay() {
        player!!.playWhenReady = true
    }

    fun pause() {
        player!!.playWhenReady = false
    }

    fun stop(resetStatus: Boolean) {
        player!!.stop(resetStatus)
    }

    fun release() {
        player!!.release()
    }

    fun isPlayer(): Boolean {
        return player != null
    }

    fun isListSource(): Boolean {
        return concatenatingMediaSource != null
    }

    fun isDataSource(): Boolean {
        return mediaSource != null
    }

    fun isPlaying(): Boolean {
        return player!!.playWhenReady
    }

    fun setAudioFocus(status : Boolean) {
        player!!.setAudioAttributes(audioAttributes, status)
    }

    fun onListener(action: (Int) -> Unit) {
        setListener()
        listener = object : Listener {
            override fun status(playbackState: Int) {
                action(playbackState)
            }
        }
    }

    private fun setListener() {
        player!!.addListener(object : Player.EventListener {
            override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
                listener.status(playbackState)
            }
        })
    }
}