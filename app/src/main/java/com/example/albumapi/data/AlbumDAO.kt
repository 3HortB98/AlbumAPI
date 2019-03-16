package com.example.albumapi.data

import android.arch.persistence.room.*

import com.example.albumapi.AlbumItem
import io.reactivex.Maybe


@Dao
interface AlbumDAO {
    @Query("SELECT * FROM albums")
    fun getAllAlbums(): Maybe<List<AlbumItem>>

    @Insert
    fun addAlbum(album : AlbumItem)

    @Delete
    fun deleteAlbum(album : AlbumItem)

    @Update
    fun updateAlbum(album: AlbumItem)
}