package com.josancamon19.toolboxtestapp.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.josancamon19.toolboxtestapp.adapters.viewholders.PostersViewHolder
import com.josancamon19.toolboxtestapp.adapters.viewholders.ThumbsViewHolder
import com.josancamon19.toolboxtestapp.models.Carousel
import com.josancamon19.toolboxtestapp.models.DiffUtilCarousel
import com.josancamon19.toolboxtestapp.models.Item

private const val ITEM_VIEW_TYPE_POSTER = 0
private const val ITEM_VIEW_TYPE_THUMB = 1

class ListAdapterMain(private val onItemClicked: OnItemClicked) :
    ListAdapter<Carousel, RecyclerView.ViewHolder>(DiffUtilCarousel()) {

    interface OnItemClicked {
        fun setOnItemClicked(item: Item)
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).type) {
            "poster" -> ITEM_VIEW_TYPE_POSTER
            "thumb" -> ITEM_VIEW_TYPE_THUMB
            else -> ITEM_VIEW_TYPE_THUMB
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_POSTER -> PostersViewHolder.from(parent, onItemClicked)
            ITEM_VIEW_TYPE_THUMB -> ThumbsViewHolder.from(parent, onItemClicked)
            else -> throw  ClassCastException("Unknown ViewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PostersViewHolder -> {
                val item = getItem(position)
                holder.bind(item)
            }
            is ThumbsViewHolder -> {
                val item = getItem(position)
                holder.bind(item)
            }
        }
    }
}