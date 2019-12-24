package com.josancamon19.toolboxtestapp.models

import androidx.recyclerview.widget.DiffUtil

data class Carousel(
    val items: List<Item>,
    val title: String,
    val type: String
)

class DiffUtilCarousel : DiffUtil.ItemCallback<Carousel>() {
    override fun areItemsTheSame(oldItem: Carousel, newItem: Carousel) =
        oldItem.title == newItem.title

    override fun areContentsTheSame(oldItem: Carousel, newItem: Carousel) = oldItem == newItem

}