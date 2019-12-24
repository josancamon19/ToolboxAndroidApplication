package com.josancamon19.toolboxtestapp.adapters

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, itemUrl: String?) {
    itemUrl?.let {
        val posterUri = Uri.parse(itemUrl.trim())
        Glide.with(imgView.context)
            .load(posterUri)
//            .apply(
//                RequestOptions()
//                    .placeholder(R.drawable.loading_animation)
//                    .error(R.drawable.placeholder)
//            )
            .into(imgView)
    }
}