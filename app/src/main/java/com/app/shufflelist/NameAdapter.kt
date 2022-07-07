package com.app.shufflelist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.shufflelist.databinding.ItemNameBinding

class NameAdapter constructor(
    private var context: Context,
    private var items: List<ItemsViewModel>,
) : RecyclerView.Adapter<NameAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            ItemNameBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name = items[position]
        holder.binding.apply {
            tvName.text = name.text
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(val binding: ItemNameBinding) :
        RecyclerView.ViewHolder(binding.root)
}