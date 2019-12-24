package com.josancamon19.toolboxtestapp.adapters.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.josancamon19.toolboxtestapp.R
import com.josancamon19.toolboxtestapp.adapters.ListAdapterMain
import com.josancamon19.toolboxtestapp.adapters.subadapters.ListAdapterPoster
import com.josancamon19.toolboxtestapp.adapters.subadapters.ListAdapterThumb
import com.josancamon19.toolboxtestapp.databinding.ListItemBaseBinding
import com.josancamon19.toolboxtestapp.databinding.ListItemPosterBinding
import com.josancamon19.toolboxtestapp.models.Carousel
import com.josancamon19.toolboxtestapp.models.Item

class PostersViewHolder(private val itemBinding: ListItemBaseBinding, private val onItemClicked: ListAdapterMain.OnItemClicked) :
    RecyclerView.ViewHolder(itemBinding.root) {

    companion object {
        fun from(parent: ViewGroup, onItemClicked: ListAdapterMain.OnItemClicked): PostersViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_base, parent, false)
            return PostersViewHolder(ListItemBaseBinding.bind(view), onItemClicked)
        }
    }

    fun bind(carousel: Carousel) {
        val carouselAdapter = ListAdapterPoster(onItemClicked)
        itemBinding.tvCarouselTitle.text = carousel.title
        itemBinding.recyclerBase.apply {
            setHasFixedSize(true)
            adapter = carouselAdapter
        }
        carouselAdapter.submitList(carousel.items)
        itemBinding.executePendingBindings()
    }
}