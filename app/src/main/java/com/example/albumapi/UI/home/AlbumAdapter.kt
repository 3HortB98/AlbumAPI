package com.example.albumapi.UI.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.albumapi.AlbumItem
import com.example.albumapi.R
import kotlinx.android.synthetic.main.album_item.view.*

class AlbumAdapter:RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    private val albumData = ArrayList<AlbumItem>()

    fun setData(albums : List<AlbumItem>){
        albumData.clear()
        albumData.addAll(albums)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): AlbumViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.album_item,parent,false)
        return AlbumViewHolder(view)
    }

    override fun getItemCount() = albumData.size

    override fun onBindViewHolder(albumViewHolder: AlbumViewHolder, position: Int) {
        //viewHolder.tvAuthor.text = data[position].author
        albumViewHolder.tvId.text = albumData[position].id.toString()
        albumViewHolder.tvTitle.text = albumData[position].title
        albumViewHolder.tvUserID.text =albumData[position].userId.toString()
    }

    class AlbumViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvId: TextView = view.findViewById(R.id.tvId)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvUserID: TextView = view.findViewById(R.id.tvUserID)
    }

}