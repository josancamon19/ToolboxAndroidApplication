package com.josancamon19.toolboxtestapp.adapters.subadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.josancamon19.toolboxtestapp.R
import com.josancamon19.toolboxtestapp.adapters.ListAdapterMain
import com.josancamon19.toolboxtestapp.databinding.ListItemPosterBinding
import com.josancamon19.toolboxtestapp.models.DiffUtilItem
import com.josancamon19.toolboxtestapp.models.Item

class ListAdapterPoster(private val onItemClicked: ListAdapterMain.OnItemClicked) :
    ListAdapter<Item, ListAdapterPoster.PosterViewHolder>(DiffUtilItem()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_poster, parent, false)
        return PosterViewHolder(ListItemPosterBinding.bind(view), onItemClicked)
    }

    override fun onBindViewHolder(holder: PosterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class PosterViewHolder(
        private val itemBinding: ListItemPosterBinding,
        private val onItemClicked: ListAdapterMain.OnItemClicked
    ) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: Item) {
            itemBinding.tvPosterTitle.text = item.title
            itemBinding.itemImageUrl = item.imageUrl
            itemBinding.ivPoster.setOnClickListener {
                onItemClicked.setOnItemClicked(item)
            }
            itemBinding.executePendingBindings()
        }
    }
}