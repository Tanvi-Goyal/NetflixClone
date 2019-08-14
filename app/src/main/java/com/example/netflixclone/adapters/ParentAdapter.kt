package com.example.netflixclone.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixclone.BaseViewHolder
import com.example.netflixclone.databinding.SubItemBinding
import com.example.netflixclone.databinding.SubRecyclerBinding
import com.example.netflixclone.models.ParentModel
import com.example.netflixclone.models.VideoModel

class ParentAdapter : RecyclerView.Adapter<BaseViewHolder<*>>() {

    var adapterDataList: List<Any> = emptyList()

    companion object {
        private const val TYPE_RECYCLER = 0
        private const val TYPE_VIDEO = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {

            TYPE_RECYCLER -> {
                return RecyclerViewHolder(
                    SubRecyclerBinding.inflate(
                        LayoutInflater.from(parent?.context),
                        parent,
                        false
                    )
                )
            }

            TYPE_VIDEO -> {
                return VideoViewHolder(
                    SubItemBinding.inflate(
                        LayoutInflater.from(parent?.context),
                        parent,
                        false
                    )
                )
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val element = adapterDataList[position]
        when (holder) {
            is RecyclerViewHolder -> holder.bind(element as ParentModel)
            is VideoViewHolder -> holder.bind(element as VideoModel)
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemCount(): Int {

        return adapterDataList.size
    }

    override fun getItemViewType(position: Int): Int {
        val comparable = adapterDataList[position]
        return when (comparable) {
            is ParentModel -> TYPE_RECYCLER
            is VideoModel -> TYPE_VIDEO
            else -> throw IllegalArgumentException("Invalid type of data " + position)
        }
    }

    inner class RecyclerViewHolder(private val itemBinding: SubRecyclerBinding) :
        BaseViewHolder<ParentModel>(itemBinding.root) {

        override fun bind(itemViewModel: ParentModel) {
            itemBinding.parentviewmodel = itemViewModel
            itemBinding.executePendingBindings()

            itemBinding.recyclerSub.layoutManager =
                LinearLayoutManager(itemBinding.recyclerSub.context, LinearLayout.HORIZONTAL, false)
            val childAdapter = ChildAdapter()
            itemBinding.recyclerSub.adapter = childAdapter

            childAdapter.childAdapterDataList = itemViewModel.children

        }
    }

    inner class VideoViewHolder(private val itemBinding: SubItemBinding) :
        BaseViewHolder<VideoModel>(itemBinding.root) {

        override fun bind(itemViewModel: VideoModel) {
            //Do your view assignment here from the data model
            itemBinding.videoviewmodel = itemViewModel
            itemBinding.executePendingBindings()
        }
    }
}