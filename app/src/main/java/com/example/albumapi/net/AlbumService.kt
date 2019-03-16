package com.example.albumapi.net


import com.example.albumapi.AlbumItem
import com.example.albumapi.ENDPOINT
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path

interface  AlbumService{
    @GET(ENDPOINT)
    fun getAlbums(): Single<List<AlbumItem>>
}