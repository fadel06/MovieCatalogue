package com.belajar.moviecatalogue.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.belajar.moviecatalogue.R
import com.belajar.moviecatalogue.data.source.local.entity.MovieEntity
import com.belajar.moviecatalogue.databinding.ItemGridListBinding
import com.belajar.moviecatalogue.ui.detail.DetailActivity
import com.belajar.moviecatalogue.ui.detail.DetailViewModel.Companion.MOVIE
import com.belajar.moviecatalogue.utils.getIdDrawable
import com.belajar.moviecatalogue.utils.visibility
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MovieAdapter: PagedListAdapter<MovieEntity, MovieAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    private var type: String? = null

    fun getType(type: String?){
        this.type = type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemGridListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) holder.bind(movie)
    }

    inner class ViewHolder(private val binding: ItemGridListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity){
            with(binding){
                tvTitle.text = movie.title
                tvRating.text = movie.rating
                Glide.with(itemView.context)
                    .load(getIdDrawable(itemView.context, movie.poster))
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgPoster)
                itemView.setOnClickListener {
                    if (groupTitle.visibility == View.GONE) {
                        groupTitle visibility true
                    } else {
                        val intent = Intent(itemView.context, DetailActivity::class.java)
                        intent.putExtra(DetailActivity.EXTRA_ID_ITEM, movie.id)
                        intent.putExtra(DetailActivity.EXTRA_TYPE, MOVIE)
                        itemView.context.startActivity(intent)
                        groupTitle visibility false
                    }
                }
            }
        }

    }
}