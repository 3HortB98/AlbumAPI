package com.example.albumapi.data

import android.app.Application
import android.arch.persistence.room.Room
import com.example.albumapi.AlbumItem
import com.example.albumapi.DATABASE_NAME
import io.reactivex.Maybe

class LocalDataSource(private val application: Application) : DataSource{
    override fun getAlbums()=database.albumDAO().getAllAlbums()


    private val database :AlbumDatabase by lazy {
        Room.databaseBuilder(application,AlbumDatabase::class.java, DATABASE_NAME)
            .build()
    }


    override fun addAlbum(album: AlbumItem) {
        database.albumDAO().addAlbum(album)
    }

}