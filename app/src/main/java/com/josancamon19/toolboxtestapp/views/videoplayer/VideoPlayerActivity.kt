package com.josancamon19.toolboxtestapp.views.videoplayer

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.josancamon19.toolboxtestapp.R
import com.josancamon19.toolboxtestapp.databinding.ActivityVideoPlayerBinding

class VideoPlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVideoPlayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_video_player)
        intent.getStringExtra("video_url").let {
            if (it == null) {
                binding.tvVideoNotFound.visibility = View.VISIBLE
                binding.exoplayerVideoLayout.visibility = View.GONE
            } else {
                binding.tvVideoNotFound.visibility = View.GONE
                binding.exoplayerVideoLayout.visibility = View.VISIBLE
                binding.exoplayerVideoLayout.setVideoURI(Uri.parse(it))
                binding.exoplayerVideoLayout.setOnPreparedListener {
                    binding.exoplayerVideoLayout.start()
                }

            }
        }
    }
}
