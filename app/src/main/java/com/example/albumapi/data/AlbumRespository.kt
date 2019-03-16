package com.example.albumapi.data


import com.example.albumapi.AlbumItem
import io.reactivex.Maybe

class AlbumRespository( private val localDataSource: LocalDataSource,
                        private val remoteDataSource: RemoteDataSource):DataSource{
    override fun getAlbums(): Maybe<List<AlbumItem>> {
        return remoteDataSource.getAlbums()
            .doOnSuccess {
                    it.forEach { album->addAlbum(album) }}
                //it}
            .onErrorResumeNext { _: Throwable -> localDataSource.getAlbums() }
    }

    override fun addAlbum(album: AlbumItem) {
        localDataSource.addAlbum(album)
    }

}