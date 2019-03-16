package com.example.albumapi.data


import com.example.albumapi.AlbumItem
import io.reactivex.Maybe

interface DataSource{
    fun getAlbums():Maybe<List<AlbumItem>>
    fun addAlbum(album :AlbumItem)
}