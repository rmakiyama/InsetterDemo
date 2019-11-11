package com.rmakiyama.insetterdemo.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rmakiyama.insetterdemo.databinding.ItemDemoBinding

internal class DemoListAdapter : ListAdapter<String, DemoViewHolder>(DemoDiff) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DemoViewHolder {
        return DemoViewHolder(
            ItemDemoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: DemoViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }
}

internal class DemoViewHolder(
    private val binding: ItemDemoBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(text: String) {
        binding.text.text = text
    }
}

object DemoDiff : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(
        oldItem: String,
        newItem: String
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: String,
        newItem: String
    ): Boolean {
        return oldItem == newItem
    }
}
