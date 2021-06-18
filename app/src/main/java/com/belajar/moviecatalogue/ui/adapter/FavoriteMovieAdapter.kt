package com.belajar.moviecatalogue.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.belajar.moviecatalogue.R
import com.belajar.moviecatalogue.data.source.local.entity.MovieEntity
import com.belajar.moviecatalogue.databinding.ItemLinearListBinding
import com.belajar.moviecatalogue.ui.detail.DetailActivity
import com.belajar.moviecatalogue.ui.detail.DetailViewModel.Companion.MOVIE
import com.belajar.moviecatalogue.utils.getIdDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class FavoriteMovieAdapter : RecyclerView.Adapter<FavoriteMovieAdapter.ViewHolder>() {

    private var listItems = ArrayList<MovieEntity>()
    private var type: String? = null

    fun setItems(items: List<MovieEntity>?, type: String?){
        if (items == null) return
        this.listItems.clear()
        this.listItems.addAll(items)
        this.type = type
    }

    fun getSwipedData(swipedPosition: Int): MovieEntity = listItems[swipedPosition]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemLinearListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = listItems[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listItems.size

    inner class ViewHolder(private val binding: ItemLinearListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                tvTitle.text = movie.title
                tvRating.text = movie.rating
                Glide.with(itemView.context)
                    .load(getIdDrawable(itemView.context, movie.poster))
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgPoster)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_ID_ITEM, movie.id)
                    intent.putExtra(DetailActivity.EXTRA_TYPE, MOVIE)
                    itemView.context?.startActivity(intent)
                }
            }
        }
    }


}