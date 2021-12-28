package com.example.bravo3leek

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class Bravo3leekActivity : AppCompatActivity() {
    lateinit var videoView: VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bravo3leek)
        videoView = findViewById(R.id.videoView)
        val mediaController = android.widget.MediaController(this)
        mediaController.setAnchorView(videoView)
        val video: Uri = Uri.parse("android.resource://$packageName/${R.raw.barvo3leek}")
        videoView.setVideoURI(video)
        videoView.requestFocus()
        videoView.start()
        startHomeActivity()
    }

    private fun startHomeActivity() {
        Handler(Looper.getMainLooper()).postDelayed({
            start()
        }, 3000)
    }

    private fun start() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}