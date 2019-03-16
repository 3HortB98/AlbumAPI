package com.example.albumapi.UI.home

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.albumapi.AlbumItem
import com.example.albumapi.data.AlbumRespository
import com.example.albumapi.data.DataSource
import com.example.albumapi.data.LocalDataSource
import com.example.albumapi.data.RemoteDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel :ViewModel(){
    private val albumObservable: MutableLiveData<List<AlbumItem>> = MutableLiveData()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getAlbumObservable():LiveData<List<AlbumItem>> = albumObservable

    private lateinit var repository : DataSource

    private lateinit var albumAdapter: AlbumAdapter

    fun getAlbums(application: Application){
        albumAdapter = AlbumAdapter()
        repository= AlbumRespository(remoteDataSource = RemoteDataSource(),
            localDataSource = LocalDataSource(application))

        compositeDisposable.add(repository.getAlbums()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                albumObservable.value= it
            },{
                it.printStackTrace()
            }))

    }
}