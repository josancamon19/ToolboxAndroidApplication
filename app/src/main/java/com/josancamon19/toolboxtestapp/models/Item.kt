package com.josancamon19.toolboxtestapp.models

import androidx.recyclerview.widget.DiffUtil

data class Item(
    val description: String,
    val imageUrl: String,
    val title: String,
    val videoUrl: String
)

class DiffUtilItem : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item) = oldItem.title == newItem.title

    override fun areContentsTheSame(oldItem: Item, newItem: Item) = oldItem == newItem

}