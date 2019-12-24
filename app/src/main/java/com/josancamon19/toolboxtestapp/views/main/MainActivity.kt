package com.josancamon19.toolboxtestapp.views.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.josancamon19.toolboxtestapp.R
import com.josancamon19.toolboxtestapp.adapters.ListAdapterMain
import com.josancamon19.toolboxtestapp.databinding.ActivityMainBinding
import com.josancamon19.toolboxtestapp.models.Item
import com.josancamon19.toolboxtestapp.views.videoplayer.VideoPlayerActivity
import timber.log.Timber

class MainActivity : AppCompatActivity(), ListAdapterMain.OnItemClicked {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var mainAdapter: ListAdapterMain

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        setupRecycler()
        setupViewModel()
    }

    private fun setupRecycler() {
        mainAdapter = ListAdapterMain(this)
        binding.recyclerMain.apply {
            setHasFixedSize(true)
            adapter = mainAdapter
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.carouselsResponse.observe(this, Observer {
            mainAdapter.submitList(it)
        })
    }

    override fun setOnItemClicked(item: Item) {
        val intent = Intent(this, VideoPlayerActivity::class.java)
        Timber.d(item.videoUrl)
        intent.putExtra("video_url", item.videoUrl)
        startActivity(intent)
    }
}
