package com.chani.sampleplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.chani.easyexoplayer.EasyExoPlayer
import com.google.android.exoplayer2.Player
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init player
        EasyExoPlayer.initPlayer(this, getString(R.string.app_name))
        EasyExoPlayer.setAudioFocus(true)

        val data = listOf(
            "https://d29j81y63o5tr8.cloudfront.net/sound/90541336_200506225505.m4a",
            "https://d29j81y63o5tr8.cloudfront.net/sound/37741219_200507143325.m4a",
            "https://d29j81y63o5tr8.cloudfront.net/sound/20723965_200507133322.m4a",
            "https://d29j81y63o5tr8.cloudfront.net/sound/52331111_200507124039.m4a"
        )

        //single play
        button.setOnClickListener {
            EasyExoPlayer.setDataSource("https://d29j81y63o5tr8.cloudfront.net/sound/90541336_200506225505.m4a")
            EasyExoPlayer.play()
        }

        // playlist play
        button2.setOnClickListener {
            EasyExoPlayer.setPlayListSource(data)
            EasyExoPlayer.play()
        }

        //play pause
        button3.setOnClickListener {
            EasyExoPlayer.pause()
        }

        button4.setOnClickListener {
            EasyExoPlayer.stop(true)
        }

        button5.setOnClickListener {
            EasyExoPlayer.rePlay()
        }
    }
}
