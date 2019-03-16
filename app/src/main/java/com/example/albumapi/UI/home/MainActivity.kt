package com.example.albumapi.UI.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.albumapi.AlbumItem
import com.example.albumapi.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val albumAdapter = AlbumAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAlbums.layoutManager = LinearLayoutManager(this)
        rvAlbums.adapter = albumAdapter

        val homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        val observer = Observer<List<AlbumItem>> { results->
            if (results != null) {
                albumAdapter.setData(results)
            }
        }


        homeViewModel.getAlbums(application)
        homeViewModel.getAlbumObservable().observe(this,observer)
    }
}
