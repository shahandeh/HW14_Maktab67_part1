package com.example.hw14_maktab67_part1.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.hw14_maktab67_part1.R
import com.example.hw14_maktab67_part1.util.glide

class HomeAdapter(private val listOfUrls : List<String>) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    class HomeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)
        fun bind(url : String){
            imageView.glide(url)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_image_view_sample, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(listOfUrls[position])
    }

    override fun getItemCount(): Int {
        return listOfUrls.size
    }

}