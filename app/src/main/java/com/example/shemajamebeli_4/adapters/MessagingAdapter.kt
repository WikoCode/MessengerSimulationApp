package com.example.shemajamebeli_4.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shemajamebeli_4.R
import com.example.shemajamebeli_4.databinding.ItemMessagingBinding
import com.example.shemajamebeli_4.dataclasses.MessagingItem

class MessagingAdapter : ListAdapter<MessagingItem, MessagingAdapter.MessagingViewHolder>(MessagingDiffCallback()) {

    class MessagingViewHolder(private val binding: ItemMessagingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MessagingItem) {

            binding.tvFullName.text = item.owner
            binding.tvLastMessage.text = item.lastMessage
            binding.tvLastActive.text = item.lastActive

            Glide.with(itemView.context)
                .load(item.image)
                .into(binding.ivIcon)


        }
    }

    class MessagingDiffCallback : DiffUtil.ItemCallback<MessagingItem>() {
        override fun areItemsTheSame(oldItem: MessagingItem, newItem: MessagingItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MessagingItem, newItem: MessagingItem): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessagingViewHolder {
        val binding = ItemMessagingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MessagingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MessagingViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}