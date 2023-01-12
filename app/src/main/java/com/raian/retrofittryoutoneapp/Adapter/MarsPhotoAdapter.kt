package com.raian.retrofittryoutoneapp.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.raian.retrofittryoutoneapp.R
import com.raian.retrofittryoutoneapp.network.MarsPhoto
import com.squareup.picasso.Picasso
import kotlin.math.log

class MarsPhotoAdapter(
    private val dataList: ArrayList<MarsPhoto>
):RecyclerView.Adapter<MarsPhotoAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view : View): RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.mars_image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.grid_view_item, parent,false)
        return ItemViewHolder(root)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val photo = dataList[position]
        Picasso.get().load(photo.img_src).into(holder.image)

    }

    override fun getItemCount(): Int {
        Log.v("TAG", dataList.size.toString());
        return dataList.size
    }

}