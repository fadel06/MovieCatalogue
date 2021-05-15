package com.belajar.moviecatalogue.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.belajar.moviecatalogue.R
import com.belajar.moviecatalogue.data.CrewEntity
import com.belajar.moviecatalogue.databinding.ItemCrewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CrewAdapter : RecyclerView.Adapter<CrewAdapter.ViewHolder>() {
    private var listCrew = ArrayList<CrewEntity>()

    fun setCrews(crews: List<CrewEntity>?){
        if (crews == null) return
        this.listCrew.clear()
        this.listCrew.addAll(crews)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemCrewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val crew = listCrew[position]
        holder.bind(crew)
    }

    override fun getItemCount(): Int = listCrew.size

    inner class ViewHolder (private val binding: ItemCrewBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(crew: CrewEntity){
            with(binding){
                val idResource = itemView.context.resources.getIdentifier(crew.crewPhoto, "drawable", itemView.context.packageName)
                tvName.text = crew.crewName
                tvPosition.text = crew.crewPosition

                Glide.with(itemView.context)
                    .load(idResource)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgCrew)

            }

        }

    }
}