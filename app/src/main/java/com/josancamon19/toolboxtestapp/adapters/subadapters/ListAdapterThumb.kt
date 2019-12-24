package com.josancamon19.toolboxtestapp.adapters.subadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.josancamon19.toolboxtestapp.R
import com.josancamon19.toolboxtestapp.adapters.ListAdapterMain
import com.josancamon19.toolboxtestapp.databinding.ListItemThumbBinding
import com.josancamon19.toolboxtestapp.models.DiffUtilItem
import com.josancamon19.toolboxtestapp.models.Item

class ListAdapterThumb(private val onItemClicked: ListAdapterMain.OnItemClicked) :
    ListAdapter<Item, ListAdapterThumb.ThumbViewHolder>(DiffUtilItem()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThumbViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_thumb, parent, false)
        return ThumbViewHolder(ListItemThumbBinding.bind(view), onItemClicked)
    }

    override fun onBindViewHolder(holder: ThumbViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class ThumbViewHolder(
        private val itemBinding: ListItemThumbBinding,
        private val onItemClicked: ListAdapterMain.OnItemClicked
    ) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: Item) {
            itemBinding.tvThumbTitle.text = item.title
            itemBinding.itemImageUrl = item.imageUrl
            itemBinding.ivThumb.setOnClickListener {
                onItemClicked.setOnItemClicked(item)
            }
            itemBinding.executePendingBindings()
        }
    }
}