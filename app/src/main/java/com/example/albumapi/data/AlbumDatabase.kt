package com.example.albumapi.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

import com.example.albumapi.AlbumItem
import com.example.albumapi.DATABASE_VERSION

@Database(entities = [AlbumItem:: class],version = DATABASE_VERSION)
abstract class AlbumDatabase : RoomDatabase(){
    abstract fun albumDAO(): AlbumDAO
}