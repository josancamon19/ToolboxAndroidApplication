package com.josancamon19.toolboxtestapp.adapters.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.josancamon19.toolboxtestapp.R
import com.josancamon19.toolboxtestapp.adapters.ListAdapterMain
import com.josancamon19.toolboxtestapp.adapters.subadapters.ListAdapterThumb
import com.josancamon19.toolboxtestapp.databinding.ListItemBaseBinding
import com.josancamon19.toolboxtestapp.databinding.ListItemPosterBinding
import com.josancamon19.toolboxtestapp.models.Carousel
import com.josancamon19.toolboxtestapp.models.Item

class ThumbsViewHolder(private val itemBinding: ListItemBaseBinding, private val onItemClicked: ListAdapterMain.OnItemClicked) :
    RecyclerView.ViewHolder(itemBinding.root) {

    companion object {
        fun from(parent: ViewGroup, onItemClicked: ListAdapterMain.OnItemClicked): ThumbsViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_base, parent, false)
            return ThumbsViewHolder(ListItemBaseBinding.bind(view), onItemClicked)
        }
    }

    fun bind(carousel: Carousel) {
        val carouselAdapter = ListAdapterThumb(onItemClicked)
        itemBinding.tvCarouselTitle.text = carousel.title
        itemBinding.recyclerBase.apply {
            setHasFixedSize(true)
            adapter = carouselAdapter
        }
        carouselAdapter.submitList(carousel.items)
        itemBinding.executePendingBindings()
    }
}