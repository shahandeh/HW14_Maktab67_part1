package com.example.hw14_maktab67_part1.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.hw14_maktab67_part1.R

fun ImageView.glide(input : String){
    Glide.with(context)
        .load(input)
        .placeholder(R.drawable.loading_animation)
        .into(this)
}