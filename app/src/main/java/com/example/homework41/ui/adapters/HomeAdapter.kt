package com.example.homework41.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework41.data.models.DataItem
import com.example.homework41.databinding.ItemHomeBinding

class HomeAdapter(
    private val onClickListener: (id: String) -> Unit
) :
    ListAdapter<DataItem, HomeAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(bindingAdapterPosition).apply { onClickListener(id) }
            }
        }

        fun onBind(item: DataItem) {
            Glide.with(binding.imageAnime.context)
                .load(item.attributes.posterImage.original)
                .into(binding.imageAnime)
            binding.tvName.text = item.attributes.titles.enJp
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<DataItem>() {
            override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem.attributes.titles == newItem.attributes.titles
            }

            override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}