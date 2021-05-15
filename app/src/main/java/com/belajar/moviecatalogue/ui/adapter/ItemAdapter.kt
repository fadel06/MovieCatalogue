package com.belajar.moviecatalogue.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.belajar.moviecatalogue.R
import com.belajar.moviecatalogue.data.ItemEntity
import com.belajar.moviecatalogue.databinding.ItemListBinding
import com.belajar.moviecatalogue.ui.detail.DetailActivity
import com.belajar.moviecatalogue.utils.visibility
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ItemAdapter: RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    private var listItems = ArrayList<ItemEntity>()

    private var type: String? = null

    fun setItems(items: List<ItemEntity>?, type: String?){
        if (items == null) return
        this.listItems.clear()
        this.listItems.addAll(items)
        this.type = type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listItems[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = listItems.size

    inner class ViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemEntity){
            with(binding){
                val idResource = itemView.context.resources.getIdentifier(item.poster, "drawable", itemView.context.packageName)
                tvTitle.text = item.title
                tvRating.text = item.rating
                Glide.with(itemView.context)
                    .load(idResource)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgPoster)
                itemView.setOnClickListener {
                    if (groupTitle.visibility == View.GONE) {
                        groupTitle visibility true
                    } else {
                        val intent = Intent(itemView.context, DetailActivity::class.java)
                        intent.putExtra(type, item.id)
                        itemView.context.startActivity(intent)
                        groupTitle visibility false
                    }
                }
            }
        }

    }
}