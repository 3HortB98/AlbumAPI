package com.example.albumapi.data

import com.example.albumapi.AlbumItem
import com.example.albumapi.BASE_URL
import com.example.albumapi.net.AlbumService
import io.reactivex.Maybe
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RemoteDataSource:DataSource{

    private val albumService: AlbumService by lazy {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        retrofit.create(AlbumService::class.java)
    }
    override fun getAlbums(): Maybe<List<AlbumItem>> {

        //return albumService.getAlbums().flatMapMaybe { Maybe.just(it) }
        return albumService.getAlbums().flatMapMaybe { Maybe.just(it) }
        }

override fun addAlbum(album: AlbumItem) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

}