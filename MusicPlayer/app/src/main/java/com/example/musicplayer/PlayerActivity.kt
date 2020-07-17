package com.example.musicplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_player.*

class PlayerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        btn_play.setOnClickListener {
            var mediaPlayer: MediaPlayer ? = MediaPlayer.create(applicationContext,R.raw.music)
            mediaPlayer?.start()

            progressBar
        }

    }

}
