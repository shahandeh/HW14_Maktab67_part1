package com.example.hw14_maktab67_part1.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.hw14_maktab67_part1.R
import com.example.hw14_maktab67_part1.util.glide

class SearchAdapter(private val listOfUrls : List<String>) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    class SearchViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        private val imageView: ImageView = itemView.findViewById(R.id.search_image_view)

        fun bind(url : String){
            imageView.glide(url)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_image_view_sample, parent, false)
        return SearchViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(listOfUrls[position])
    }

    override fun getItemCount(): Int {
        return listOfUrls.size
    }

}