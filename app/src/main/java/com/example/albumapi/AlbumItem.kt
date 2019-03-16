package com.example.albumapi

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


/*data class AlbumItem(
    val albums: List<Album>
)*/
@Entity(tableName = TABLE_NAME)
data class AlbumItem(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val userId: Int
)