package com.belajar.moviecatalogue.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.belajar.moviecatalogue.R
import com.belajar.moviecatalogue.data.source.local.entity.TvShowEntity
import com.belajar.moviecatalogue.databinding.ItemLinearListBinding
import com.belajar.moviecatalogue.ui.detail.DetailActivity
import com.belajar.moviecatalogue.ui.detail.DetailViewModel.Companion.TV_SHOW
import com.belajar.moviecatalogue.utils.getIdDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class FavoriteTvShowAdapter : PagedListAdapter<TvShowEntity, FavoriteTvShowAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

//    private var listItems = ArrayList<TvShowEntity>()
    private var type: String? = null

    fun getType(type: String?){
        this.type = type
    }

    fun getSwipedData(swipedPosition: Int): TvShowEntity? = getItem(swipedPosition)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemLinearListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) holder.bind(tvShow)
    }

    inner class ViewHolder(private val binding: ItemLinearListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowEntity) {
            with(binding) {
                tvTitle.text = tvShow.title
                tvRating.text = tvShow.rating
                Glide.with(itemView.context)
                    .load(getIdDrawable(itemView.context, tvShow.poster))
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgPoster)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_ID_ITEM, tvShow.id)
                    intent.putExtra(DetailActivity.EXTRA_TYPE, TV_SHOW)
                    itemView.context?.startActivity(intent)
                }
            }
        }
    }


}